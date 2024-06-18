package com.socketserver.hugo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SocektMain {
    
    @Autowired
    private HttpServletRequest request;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public void greeting(String message) throws Exception {
        String clientIP = request.getRemoteAddr();
        System.out.println("Client IP: " + clientIP);
        System.out.println("Received message: " + message);
    }
}
