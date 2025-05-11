package com.ChatMicroservice.service.ServiceImplemantation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional; 

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ChatMicroservice.entity.Message;
import com.ChatMicroservice.exception.CustomRuntimeException;
import com.ChatMicroservice.repository.ChatRepository;
import com.ChatMicroservice.service.ChatService;


@Service
public class ChatServiceImplementation implements ChatService {

    @Autowired
    private  ChatRepository ChatRepository;

    private ChatClient chatClient;

    public ChatServiceImplementation( ChatClient.Builder builder) {
       
        this.chatClient = builder.build();
    }

    @Override
    public Message save(Message message) {
        try {
            message.setAnswerByAI(chatClient.prompt(message.getUserQuestion()).call().content()); 
            message.setCreationDate(LocalDateTime.now());
            return ChatRepository.save(message);
            
        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "Message_Post",
                     "Message", List.of());
        }

       
        
    }

    @Override
    public List<Message> getbySenderId(String senderId) {
        try {
           return ChatRepository.findBySenderId(senderId);
        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "Message_Get",
                                "MessageList", List.of());
        }
    }

    

   

    
}
