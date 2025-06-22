package com.ChatMicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPost {

     private String title;
    private String link;
    private String company;
    private String location;
    private String description;
    private String postedTime;
   
}
