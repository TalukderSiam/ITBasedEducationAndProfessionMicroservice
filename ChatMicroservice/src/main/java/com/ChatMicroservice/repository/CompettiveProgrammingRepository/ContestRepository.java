package com.ChatMicroservice.repository.CompettiveProgrammingRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ChatMicroservice.entity.Message;
import com.ChatMicroservice.entity.CompettiveProgramming.Contest;

public interface ContestRepository extends JpaRepository<Contest, Integer> {

}
