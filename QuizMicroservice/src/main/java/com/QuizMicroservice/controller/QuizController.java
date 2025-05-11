package com.QuizMicroservice.controller;
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
import com.QuizMicroservice.entity.Quiz;
import com.QuizMicroservice.dto.request.UserQuizSubmission;
import com.QuizMicroservice.dto.response.RootResponseModel;
import com.QuizMicroservice.service.QuizService;
import com.QuizMicroservice.utils.ResponseOfApi;



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

    @GetMapping("/getbysubjectnameandnumberofday")
        public ResponseEntity<RootResponseModel<?>> getbysubjectnameandnumberofday(@RequestParam String SubjectName , @RequestParam String NumberOfDay) {
    
            List<Quiz> savedQuizQuetionList= QuizService.getbysubjectnameandnumberofday(SubjectName,NumberOfDay);
    
            RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                    true,
                    "Quiz_Get",
                    "Get Quiz Quetion List Successfully",
                    "QuizList",
                    savedQuizQuetionList);
    
         
            return ResponseEntity.ok(response);
        }
        //https://github.com/bhanujoshi24/teluskoContest/blob/main/QuizApplication/src/main/java/com/telusko/contest/controller/UserController.java

        @PostMapping("/submit")
    public ResponseEntity<RootResponseModel<?>> submitQuiz(@RequestBody UserQuizSubmission   userQuizSubmission) {

        int correctAnswer= QuizService.submitQuiz(userQuizSubmission);
        List<Map<String, Object>> content = List.of(Map.of("correctAnswer", correctAnswer));

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "Quiz_Post",
                "Saved Quiz Successfully",
                "Quiz",
                content);

     
        return ResponseEntity.ok(response);
    }

}
