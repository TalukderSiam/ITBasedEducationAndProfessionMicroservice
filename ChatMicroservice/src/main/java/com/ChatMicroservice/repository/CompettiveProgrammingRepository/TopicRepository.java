package com.ChatMicroservice.repository.CompettiveProgrammingRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ChatMicroservice.entity.Message;
import com.ChatMicroservice.entity.CompettiveProgramming.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    
}
