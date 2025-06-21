package com.ChatMicroservice.service.ServiceImplemantation;

import com.ChatMicroservice.entity.Interview;
import com.ChatMicroservice.entity.InterviewTopic;
import com.ChatMicroservice.repository.InterviewRepository;
import com.ChatMicroservice.repository.InterviewTopicRepository;
import com.ChatMicroservice.service.IInterviewService;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IInterviewServiceImplementation implements IInterviewService {

    @Autowired
    private InterviewTopicRepository interviewTopicRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    private final ChatClient chatClient;

    public IInterviewServiceImplementation(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
    }

    @Transactional
    @Override
    public Interview startinterview(InterviewTopic interviewTopic) {
        String promptText = "You are a professional interviewer. Start an interview with {username} on the topic of {topicName}  The level is {level} Ask the first question  is Tell me about youself.Return only  questions as strings, no other text.";

        PromptTemplate promptTemplate = new PromptTemplate(promptText);
        Prompt prompt = promptTemplate.create(Map.of(
                "topicName", interviewTopic.getTopicName(),
                "level", interviewTopic.getLevel(),
                "username", interviewTopic.getUserName()));
        String firstQuestion = chatClient.prompt(prompt).call().content();
        interviewTopic.setFirstQuetionByAI(firstQuestion);
        System.out.println(interviewTopic);

        InterviewTopic savedInterviewTopic = interviewTopicRepository.save(interviewTopic);
        Interview interview = Interview.builder()
                .interviewTopicId(savedInterviewTopic.getId())
                .questionAskedByAI(savedInterviewTopic.getFirstQuetionByAI())
                .build();

        return interview;
    }

    @Override
    public Interview evaluateUserAnswer(Interview interview) {

        String promptText = """
                    You are conducting an interview on {subject}.Its like you asked a quetion the inviewer and then he response you question answer then you evaluate then ask another new quetion of this level .Also you give evaluate the answer like real time happend .Use "you"That like real time interview happening . The last  question you asked was: "{question}".
                    The candidate answered: "{answer}".
                    Evaluate the answer, say whether it's correct, and briefly explain why.
                    Then, ask the next question in the interview.

                    Requirements:
                    - Questions should be appropriate for {level} level
                    - Cover different aspects of {subject}
                    - Include both theoretical and practical questions
                    - Avoid yes/no questions
                    - Make questions specific and challenging
                    - Focus on real-world scenarios and problem-solving

                        Return only questions as strings, no other text. Please do not include any characters other than English letters, full stops, and commas. Avoid using newline characters like \\n because the text will be converted to voice in React.
                """;

        PromptTemplate promptTemplate = new PromptTemplate(promptText);
        Prompt prompt = promptTemplate.create(Map.of(
                "subject", interview.getTopic(),
                "question", interview.getQuestionAskedByAI(),
                "answer", interview.getUserResponse(),
                "level", interview.getLevel() // Ensure the `Interview` class has a `getLevel()` method or adjust
                                              // accordingly
        ));

        String evaluateUserAnswer = chatClient.prompt(prompt).call().content();

        Interview savedInterviewTopic = interviewRepository.save(interview);

        Interview newInterview = Interview.builder()
                .interviewTopicId(interview.getId())
                .questionAskedByAI(evaluateUserAnswer)
                .build();

        return newInterview;
    }
}
