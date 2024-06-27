package com.socketserver.hugo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.socketserver.hugo.dto.ResJsonDTO;

@Controller
@RequestMapping("/test")
public class TestController {

       // =========================================================================요청테스트====================

    @SuppressWarnings("unchecked")
    @GetMapping("/threadTest")
    public @ResponseBody ResponseEntity threadTest() throws InterruptedException {
        System.out.println("===요청!!! theadTest===");
        long start = System.currentTimeMillis();
        long end;
        ResJsonDTO json = new ResJsonDTO<>();

        
        Thread.sleep(5000);
        long tid =Thread.currentThread().getId();
        
        
        end = System.currentTimeMillis();
        long totalTime = (end-start)/1000;

        json.addJson("ThreadId", tid);
        json.addJson("totalTime", totalTime);

        return new ResponseEntity<>(json.sendJosn(),HttpStatus.OK);

    }
    

    @Async
    @SuppressWarnings("unchecked")
    @GetMapping("/asyncTest")
    public @ResponseBody ResponseEntity asyncTest() throws InterruptedException {
        System.out.println("===요청!!! asyncTest===");
        long start = System.currentTimeMillis();
        long end;
        ResJsonDTO json = new ResJsonDTO<>();

        
        Thread.sleep(5000);
        long tid =Thread.currentThread().getId();
        
        
        end = System.currentTimeMillis();
        long totalTime = (end-start)/1000;

        json.addJson("ThreadId", tid);
        json.addJson("totalTime", totalTime);

        return new ResponseEntity<>(json.sendJosn(),HttpStatus.OK);

    }
}
