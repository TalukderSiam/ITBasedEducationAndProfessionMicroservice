package com.ChatMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ChatMicroservice.dto.response.RootResponseModel;

import com.ChatMicroservice.service.ChatService;

import com.ChatMicroservice.service.TopicService;
import com.ChatMicroservice.utils.ResponseOfApi;
import com.ChatMicroservice.entity.CompettiveProgramming.Topic;
import com.ChatMicroservice.entity.CompettiveProgramming.Problem;
import com.ChatMicroservice.entity.CompettiveProgramming.Contest;

@RestController
@RequestMapping("/api/topic")
@CrossOrigin(origins = "*")
public class CompettiveProgrammingController {

    @Autowired
    private TopicService topicService;

    @PostMapping("/addnewtopic")
    public ResponseEntity<RootResponseModel<?>> addnewtopic(@RequestBody Topic Topic) {
        System.out.println();
        System.out.println(Topic);
        System.out.println();

        Topic savedTopic = topicService.addnewtopic(Topic);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "Topic_Post",
                "Saved Topic Successfully",
                "Topic",
                List.of(savedTopic));

        return ResponseEntity.ok(response);
    }

    @PostMapping("/addnewproblem")
    public ResponseEntity<RootResponseModel<?>> addnewproblem(@RequestParam int TopicId,
            @RequestBody Problem Problem) {
        System.out.println();
        System.out.println(Problem);
        System.out.println();

        Problem savedProblem = topicService.addnewProblem(TopicId, Problem);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "Problem_Post",
                "Saved Problem Successfully",
                "Problem",
                List.of(savedProblem));

        return ResponseEntity.ok(response);
    }

    @PostMapping("/addnewcontest")
    public ResponseEntity<RootResponseModel<?>> addNewContest(@RequestParam int TopicId,
            @RequestBody Contest Contest) {
        System.out.println();
        System.out.println(Contest);
        System.out.println();

        Contest savedContest = topicService.addnewContest(TopicId, Contest);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "Contest_Post",
                "Saved Contest Successfully",
                "Contest",
                List.of(savedContest));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/gettopicbyid")
    public ResponseEntity<RootResponseModel<?>> getTopicById(@RequestParam int TopicId) {
        System.out.println();
        System.out.println(TopicId);
        System.out.println();

        Topic savedTopic = topicService.getTopicById(TopicId);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "Contest_Post",
                "Saved Contest Successfully",
                "Topic",
                List.of(savedTopic));

        return ResponseEntity.ok(response);
    }

     @GetMapping("/getalltopic")
    public ResponseEntity<RootResponseModel<?>> getAllTopic() {
        // System.out.println();
        // System.out.println(TopicId);
        // System.out.println();

        List<Topic> savedTopicList = topicService.getAllTopic();

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "Contest_Post",
                "Saved Contest Successfully",
                "TopicList",
                savedTopicList);

        return ResponseEntity.ok(response);
    }

}
