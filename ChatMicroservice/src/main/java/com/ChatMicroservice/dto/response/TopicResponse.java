package com.ChatMicroservice.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicResponse {
    private int id;
    private String topicName;
    private String topicDescribtion;
    private String featureName;
    private String semester;
    // Long getId();
    // String getContestName();
    // String getPlatform();
    // Long getId();
    // String getTopicName();
    // String getTopicDescribtion(); //
    
}
