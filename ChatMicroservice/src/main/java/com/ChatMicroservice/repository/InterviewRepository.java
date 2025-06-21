package com.ChatMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ChatMicroservice.entity.Interview;



public interface InterviewRepository  extends JpaRepository<Interview, Integer> {

   

    
}
