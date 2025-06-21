package com.ChatMicroservice.service;

import com.ChatMicroservice.entity.Interview;
import com.ChatMicroservice.entity.InterviewTopic;

public interface IInterviewService {

    Interview startinterview(InterviewTopic interviewTopic);

    Interview evaluateUserAnswer(Interview interview);

}
