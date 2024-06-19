package com.socketserver.hugo.dto;

import java.util.HashMap;
import java.util.Map;

public class RobotAnswerDTO<T> {
    
    private Map<String,T> json;
    
    private T sendMessage;




    private String ORDER_NUMBER;
    // private String STATUS;
    private ACK ACK;
    private STATUS STATUS;

    public enum ACK{ZERO,ONE};
    public enum STATUS{ORDER,FINISHED,TAKEAWAY};

    private final String ZERO = "0";
    private final String ONE = "1";

    public RobotAnswerDTO() {
        json = new HashMap<>();
    }

    public RobotAnswerDTO(String oRDER_NUMBER) {
        this.ORDER_NUMBER = oRDER_NUMBER;
        json = new HashMap<>();
        json.put("ORDER_NUMBER", (T)ORDER_NUMBER);
    }

    public T getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(T send) {
        this.sendMessage = send;
    }

    public ACK getACK() {
        return ACK;
    }

    public STATUS getSTATUS(){
        return STATUS;
    }



    public String getORDER_NUMBER() {
        return ORDER_NUMBER;
    }

    public String getZERO() {
        return ZERO;
    }
    public String getONE() {
        return ONE;
    }

   public T getJsonForKey(String key){
        return json.get(key);
   }
   public Map getJson(){
    return json;
}

    public void addJson(String key,T value) {
        json.put(key, value);
    }



    public void setORDER_NUMBER(String oRDER_NUMBER) {
        ORDER_NUMBER = oRDER_NUMBER;
        json.put("ORDER_NUMBER", (T)oRDER_NUMBER);
    }
  

   
    // public void setJson(HashMap<String, String> json) {
    //     this.json = json;
    // }

    @Override
    public String toString() {
        return "RobotAnswerDTO : " + json.toString();
    }


  
    
    


}
