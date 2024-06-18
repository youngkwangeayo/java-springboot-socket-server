package com.socketserver.hugo.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    private static Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        System.out.println("Connected: " + session.getId());
        session.sendMessage(new TextMessage("Connected to WebSocket server"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.out.println("Received: " + payload);
        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                if(s.getId() == session.getId()){
                    s.sendMessage(new TextMessage("내용 : "+payload+" 전송 성공"));
                }else{
                    s.sendMessage(new TextMessage(payload));
                    System.out.println(s.getId()+"전체방 전송 :"+ payload);
                }
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        System.out.println("Disconnected: " + session.getId());
    }

    // @Bean
    public void broadCast(String message) throws Exception{
        System.out.println(message);
        for(WebSocketSession s : sessions){
            if(s.isOpen()){
                s.sendMessage(new TextMessage(message));
            }
        }
    }
    
}
