package com.socketserver.hugo.controller;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;



import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.socketserver.hugo.dto.ResJsonDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;






@Controller
public class MainController {
    

    @GetMapping("/hello")
    public @ResponseBody Map getMethodName() {
        System.out.println("===요청!!! testHello===");
        String message = "hello world";
        long tid =Thread.currentThread().getId();
        HashMap<String,Object> result = new HashMap<>();
        // HttpHeaders header =  new HttpHeaders();
        result.put("message", message);
        result.put("ThreadId", tid);
        // return "테스트중 밑에 주석풀기";
        return result;
    }

    @GetMapping("/test")
    public @ResponseBody ResponseEntity test() throws InterruptedException{
        System.out.println("진입");
        long s = System.currentTimeMillis();
        long e;
        Thread.sleep(3000);
        e = System.currentTimeMillis();
        System.out.println((e-s));

        Map<String,Object> res = new HashMap<>();
        res.put("data", "OK");

        // return "{'data' : 'OK'}";
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    
    @PostMapping("/testWathing")
    public @ResponseBody ResponseEntity testWathing(@RequestBody Map<String,Object> entity) throws InterruptedException {
        System.out.println("===========웨이팅 testWathing 진입===============");
        System.out.println(" 바디 : "+entity.toString());
        long s = System.currentTimeMillis();
        long e;
        Thread.sleep(3000);
        e = System.currentTimeMillis();
        System.out.println((e-s));
        Map<String,Object> res = new HashMap<>();
        res.put("data", "OK");
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    


 

 
}
