package com.ChatMicroservice.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime creationDate;
    private LocalDateTime updatedDate;
    private String remarks;
    private String status;
    private String userName;
    private String userId;
    private int interviewTopicId;
     @Column(length = 3000)
    private String questionAskedByAI;
     @Column(length = 3000)
    private String userResponse;
    private String topic;
    private String level;
    // private String 
    
}
