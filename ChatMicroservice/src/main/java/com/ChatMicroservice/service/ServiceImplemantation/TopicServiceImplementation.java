package com.ChatMicroservice.service.ServiceImplemantation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ChatMicroservice.entity.CompettiveProgramming.Contest;
import com.ChatMicroservice.entity.CompettiveProgramming.Problem;
import com.ChatMicroservice.entity.CompettiveProgramming.Topic;
import com.ChatMicroservice.exception.CustomRuntimeException;
import com.ChatMicroservice.repository.CompettiveProgrammingRepository.ContestRepository;
import com.ChatMicroservice.repository.CompettiveProgrammingRepository.ProblemRepository;
import com.ChatMicroservice.repository.CompettiveProgrammingRepository.TopicRepository;
import com.ChatMicroservice.service.TopicService;

@Service
public class TopicServiceImplementation implements TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private ContestRepository contestRepository;

    @Override
    public Topic addnewtopic(Topic topic) {
        try {
            return topicRepository.save(topic);
        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "Topic_Post",
                    "Topic", List.of());
        }
    }

    @Override
    public Problem addnewProblem(int topicId, Problem problem) {
        try {

            Optional<Topic> isExitTopic = topicRepository.findById(topicId);
            if (isExitTopic.isPresent()) {
                problem.setTopic(isExitTopic.get());
                return problemRepository.save(problem);
            } else {
                throw new CustomRuntimeException(false, "No found Topic Id", "Problem_Post",
                        "Problem", List.of());

            }

        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "Problem_Post",
                    "Problem", List.of());
        }
    }

    @Override
    public Contest addnewContest(int topicId, Contest contest) {

        try {

            Optional<Topic> isExitTopic = topicRepository.findById(topicId);
            if (isExitTopic.isPresent()) {
                contest.setTopic(isExitTopic.get());
                return contestRepository.save(contest);
            } else {
                throw new CustomRuntimeException(false, "No found Topic Id", "contest_Post",
                        "contest", List.of());

            }

        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "contest_Post",
                    "contest", List.of());
        }

    }

    @Override
    public Topic getTopicById(int topicId) {
        try {

            Optional<Topic> isExitTopic = topicRepository.findById(topicId);
            if (isExitTopic.isPresent()) {
                return isExitTopic.get();
            } else {
                throw new CustomRuntimeException(false, "No found Topic Id", "contest_Post",
                        "contest", List.of());

            }

        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "contest_Post",
                    "contest", List.of());
        }
    }

    @Override
    public List<Topic> getAllTopic() {
         try {

           // Optional<Topic> isExitTopic = topicRepository.findById(topicId);
            
                return topicRepository.findAll();
            

        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "contest_Post",
                    "contest", List.of());
        }
        
    }

}
