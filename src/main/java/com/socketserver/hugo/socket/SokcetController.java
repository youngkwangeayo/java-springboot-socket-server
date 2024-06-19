package com.socketserver.hugo.socket;

import org.springframework.web.bind.annotation.RestController;

import com.socketserver.hugo.dto.RobotAnswerDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SokcetController {

    @SuppressWarnings("rawtypes")
    @Autowired
    private MyWebSocketHandler myHandler;

    @SuppressWarnings("unchecked")
    @GetMapping("/hay")
    public String hay(@RequestParam(name = "req",defaultValue = "") String param) {
        System.out.println("리퀘스트쿼리"+param + param.isEmpty());

        @SuppressWarnings("rawtypes")
        RobotAnswerDTO robotAnswer = new RobotAnswerDTO("17");
        
        robotAnswer.setSendMessage("hello world");
      

        if(!param.isEmpty()){
            switch (param) {
                case "OK":
                    robotAnswer.addJson("ACK", robotAnswer.getACK().ZERO);
                    robotAnswer.addJson("STATUS", robotAnswer.getSTATUS().ORDER);
                    robotAnswer.setSendMessage(robotAnswer.getJson());
                    break;
                case "FAIL":
                    robotAnswer.addJson("STATUS", robotAnswer.getSTATUS().ORDER);
                    robotAnswer.addJson("ACK", robotAnswer.getACK().ONE);
                    robotAnswer.setSendMessage(robotAnswer.getJson());
                    break;
                case "FINISHE":
                    robotAnswer.addJson("STATUS", robotAnswer.getSTATUS().FINISHED);
                    robotAnswer.setSendMessage(robotAnswer.getJson());
                    break;
                case "TAKE":
                    robotAnswer.addJson("STATUS", robotAnswer.getSTATUS().TAKEAWAY);
                    robotAnswer.setSendMessage(robotAnswer.getJson());
                    break;
                default:
                    System.out.println("디폴트");
                    robotAnswer.setSendMessage(param);
                    break;
            }
        }
   
        try {
            myHandler.broadCast(robotAnswer.getSendMessage());
        
        } catch (Exception e) {
            System.out.println("전송 실패");
            return "전송 실패";
        }



        return "전송완료";
    }
    
}
