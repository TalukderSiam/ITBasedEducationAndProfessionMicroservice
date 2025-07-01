package com.ChatMicroservice.repository.CompettiveProgrammingRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ChatMicroservice.dto.response.TopicResponse;
import com.ChatMicroservice.entity.Message;
import com.ChatMicroservice.entity.CompettiveProgramming.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    // @Query("SELECT t.id as id, t.topicName as topicName, t.topicDescribtion as topicDescribtion FROM Topic t")
    // List<TopicResponse> findAllTopicResponse();
    @Query(value="select id,topic_name,topic_describtion,feature_name,semester from topic where feature_name=:featureName AND  semester = :semester ",nativeQuery = true)
    List<TopicResponse>getTopicWithRequiredAttributes(String featureName,String semester);

    @Query(value="select id,topic_name,topic_describtion,feature_name,semester from topic where feature_name=:featureName",nativeQuery = true)
    List<TopicResponse> getTopicForCompettiveProgramming(String featureName);

    
}
