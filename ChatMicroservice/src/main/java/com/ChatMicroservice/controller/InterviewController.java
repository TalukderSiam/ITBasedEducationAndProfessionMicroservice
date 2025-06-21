package com.ChatMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ChatMicroservice.dto.response.RootResponseModel;
import com.ChatMicroservice.entity.Interview;
import com.ChatMicroservice.entity.InterviewTopic;
import com.ChatMicroservice.service.ChatService;
import com.ChatMicroservice.service.IInterviewService;
import com.ChatMicroservice.utils.ResponseOfApi;

@RestController
@RequestMapping("/api/interview")
@CrossOrigin(origins = "*")
public class InterviewController {

    @Autowired
    private IInterviewService interviewService;


    @PostMapping("/startinterview")
    public ResponseEntity<RootResponseModel<?>> save(@RequestBody InterviewTopic  interviewTopic) {
    System.out.println();
    System.out.println(interviewTopic);
    System.out.println();
    
        Interview savedInterview= interviewService.startinterview(interviewTopic);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "Interview_Post",
                "Saved Interview Successfully",
                "Interview",
                List.of(savedInterview));

     
        return ResponseEntity.ok(response);
    }

    @PostMapping("/useranswer")
    public ResponseEntity<RootResponseModel<?>> evaluateUserAnswer(@RequestBody Interview  interview) {
   
    
        Interview savedInterview= interviewService.evaluateUserAnswer(interview);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "Interview_Post",
                "Saved Interview Successfully",
                "Interview",
                List.of(savedInterview));

     
        return ResponseEntity.ok(response);
    }

}
