package com.socketserver.hugo.dto;

public class TMessageDTO <T> {
    private T massege;

    public void setMassege() {
    }

    public void setMassege(T massege) {
        this.massege = massege;
    }

    public T send(T message){
        // System.out.println(message.getClass().);
        return message;
    }


    public T getMassege() {
        return massege;
    }


    
}
