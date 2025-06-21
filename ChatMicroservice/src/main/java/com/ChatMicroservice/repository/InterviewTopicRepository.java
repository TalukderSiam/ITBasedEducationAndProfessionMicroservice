package com.ChatMicroservice.repository;

import java.util.List;

import com.ChatMicroservice.entity.InterviewTopic;
import com.ChatMicroservice.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewTopicRepository extends JpaRepository<InterviewTopic, Integer> {

   

    
}
