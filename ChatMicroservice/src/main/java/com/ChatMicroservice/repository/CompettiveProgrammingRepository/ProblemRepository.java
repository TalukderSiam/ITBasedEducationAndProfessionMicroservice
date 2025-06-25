package com.ChatMicroservice.repository.CompettiveProgrammingRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ChatMicroservice.entity.Message;
import com.ChatMicroservice.entity.CompettiveProgramming.Problem;

public interface ProblemRepository extends JpaRepository<Problem, Integer> {

}
