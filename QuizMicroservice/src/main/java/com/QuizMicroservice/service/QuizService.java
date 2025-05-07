package com.QuizMicroservice.service;

import java.util.List;

import com.QuizMicroservice.dto.request.UserQuizSubmission;
import com.QuizMicroservice.entity.Quiz;

public interface QuizService {

    Quiz save(Quiz quiz);

    List<Quiz> getbysubjectnameandnumberofday(String subjectName, String numberOfDay);

    int submitQuiz(UserQuizSubmission userQuizSubmission);

}
