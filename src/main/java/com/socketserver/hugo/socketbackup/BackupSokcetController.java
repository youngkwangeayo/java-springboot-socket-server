// package com.socketserver.hugo.socket;

// import org.springframework.web.bind.annotation.RestController;



// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


// @RestController
// public class SokcetController {

//     @Autowired
//     private MyWebSocketHandler myHandler;

//     @GetMapping("/hay")
//     public String hay(@RequestParam(name = "tq",defaultValue = "") String param) {
//         System.out.println("리퀘스트쿼리"+param + param.isEmpty());
        
 
//         String answer ="hello world";
//         if(!param.isEmpty()){
//             answer = param;
            
//         }
   
//         try {
//             myHandler.broadCast(answer);
        
//         } catch (Exception e) {
//             // TODO: handle exception
//             return "전송 실패";
//         }



//         return "전송완료";
//     }
    
// }
