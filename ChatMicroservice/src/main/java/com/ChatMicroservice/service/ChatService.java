package com.ChatMicroservice.service;

import java.util.List;


import com.ChatMicroservice.entity.Message;


public interface ChatService {

    Message save(Message Message);

    List<Message> getbySenderId(String senderId);

    // List<Quiz> getbysubjectnameandnumberofday(String subjectName, String numberOfDay);

    // int submitQuiz(UserQuizSubmission userQuizSubmission);

}
