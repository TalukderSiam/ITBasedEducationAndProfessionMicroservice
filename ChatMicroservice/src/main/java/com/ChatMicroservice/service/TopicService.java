package com.ChatMicroservice.service;

import java.util.List;

import com.ChatMicroservice.dto.response.TopicResponse;
import com.ChatMicroservice.entity.CompettiveProgramming.Contest;
import com.ChatMicroservice.entity.CompettiveProgramming.Problem;
import com.ChatMicroservice.entity.CompettiveProgramming.Topic;

public interface TopicService {

    Topic addnewtopic(Topic topic);

    Problem addnewProblem(int topicId, Problem problem);

    Contest addnewContest(int topicId, Contest contest);

    Topic getTopicById(int topicId);

    List<TopicResponse> getAllTopic(String featureName, String semester);
    
}
