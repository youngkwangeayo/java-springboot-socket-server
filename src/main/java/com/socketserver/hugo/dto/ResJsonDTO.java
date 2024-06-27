package com.socketserver.hugo.dto;

import java.util.HashMap;
import java.util.Map;

public class ResJsonDTO <T> {
    

    
    private Map<String,T> josn;

    public ResJsonDTO() {
        this.josn = new HashMap<>();
    }

    public ResJsonDTO(Map<String, T> josn) {
        this.josn = josn;
    }

    public void addJson(String key, T data){
        this.josn.put(key, data);
    }
    
    public Map<String, T> sendJosn() {
        return josn;
    }



    
    // public void setMassege() {
    // }

    // public void setMassege(T massege) {
    //     this.massege = massege;
    // }

    // public T send(T message){
    //     // System.out.println(message.getClass().);
    //     return message;
    // }


    // public T getMassege() {
    //     return massege;
    // }


    
}
