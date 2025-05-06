package com.Quiz.Quiz.Microservice.controller;
import java.util.List;

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
import com.Quiz.Quiz.Microservice.entity.Quiz;
import com.Quiz.Quiz.Microservice.dto.response.RootResponseModel;
import com.Quiz.Quiz.Microservice.service.QuizService;
import com.Quiz.Quiz.Microservice.utils.ResponseOfApi;



@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "*")
public class QuizController {
        @Autowired
        private QuizService QuizService;

    // @Autowired
    // private CloudinaryService cloudinaryService;

    

    @PostMapping("/addquetion")
    public ResponseEntity<RootResponseModel<?>> save(@RequestBody Quiz   Quiz) {

        Quiz savedQuiz= QuizService.save(Quiz);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "Quiz_Post",
                "Saved Quiz Successfully",
                "Quiz",
                List.of(savedQuiz));

     
        return ResponseEntity.ok(response);
    }

}
