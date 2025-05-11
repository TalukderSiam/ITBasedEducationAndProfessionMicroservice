package com.ChatMicroservice.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.ChatMicroservice.entity.Message;

import com.ChatMicroservice.dto.response.RootResponseModel;
import com.ChatMicroservice.service.ChatService;
import com.ChatMicroservice.utils.ResponseOfApi;



@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {
        @Autowired
        private ChatService ChatService;

    // @Autowired
    // private CloudinaryService cloudinaryService;

    

    @PostMapping("/sendmessageai")
    public ResponseEntity<RootResponseModel<?>> save(@RequestBody Message  message) {

        Message savedMessage= ChatService.save(message);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "Message_Post",
                "Saved Message Successfully",
                "Message",
                List.of(savedMessage));

     
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getbysenderid")
        public ResponseEntity<RootResponseModel<?>> getbysubjectnameandnumberofday(@RequestParam String SenderId){
            List<Message> messageList= ChatService.getbySenderId(SenderId);
    
            RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                    true,
                    "Message_Get",
                    "Get Message  List Successfully",
                    "MessageList",
                    messageList);
    
         
            return ResponseEntity.ok(response);
        }
    //     //https://github.com/bhanujoshi24/teluskoContest/blob/main/ChatApplication/src/main/java/com/telusko/contest/controller/UserController.java

    //     @PostMapping("/submit")
    // public ResponseEntity<RootResponseModel<?>> submitChat(@RequestBody UserChatSubmission   userChatSubmission) {

    //     int correctAnswer= ChatService.submitChat(userChatSubmission);
    //     List<Map<String, Object>> content = List.of(Map.of("correctAnswer", correctAnswer));

    //     RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
    //             true,
    //             "Chat_Post",
    //             "Saved Chat Successfully",
    //             "Chat",
    //             content);

     
    //     return ResponseEntity.ok(response);
    // }

}
