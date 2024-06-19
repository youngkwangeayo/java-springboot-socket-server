package com.socketserver.hugo.controller;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Controller;



import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class MainController {
    

    @GetMapping("/hello")
    public @ResponseBody Map getMethodName() {
        String message = "hello world";
        HashMap<String,String> result = new HashMap<>();

        // HttpHeaders header =  new HttpHeaders();
        result.put("message", message);
        // return "테스트중 밑에 주석풀기";
        return result;
    }

    @GetMapping("/test")
    public @ResponseBody String test() throws InterruptedException{
        System.out.println("진입");
        long s = System.currentTimeMillis();
        long e;
        Thread.sleep(3000);
        e = System.currentTimeMillis();
        System.out.println((e-s));
        
        return "{data : OK}";
    }
    

    // @PostMapping("/test")
    // public Response handleJsonString(@RequestBody String jsonString) {
    //     // JSON 문자열을 객체로 변환
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     Response response = null;
    //     try {
    //         response = objectMapper.readValue(jsonString, Response.class);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     // 변환된 객체를 반환하거나 필요한 작업을 수행
    //     return response;
    // }
    
}
