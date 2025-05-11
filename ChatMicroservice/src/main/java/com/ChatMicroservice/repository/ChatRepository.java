
package com.ChatMicroservice.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ChatMicroservice.entity.Message;



public interface ChatRepository extends JpaRepository<Message, Integer> {

    List<Message> findBySenderId(String senderId);

    
}
