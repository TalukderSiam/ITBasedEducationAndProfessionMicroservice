package com.QuizMicroservice.service.ServiceImplemantation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizMicroservice.dto.request.AnswerSubmission;
import com.QuizMicroservice.dto.request.UserQuizSubmission;
import com.QuizMicroservice.entity.Quiz;
import com.QuizMicroservice.exception.CustomRuntimeException;
import com.QuizMicroservice.repository.QuizRepository;
import com.QuizMicroservice.service.QuizService;

@Service
public class QuizServiceImplementation implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz save(Quiz quiz) {
        try {
            quiz.setCreationDate(LocalDateTime.now());
            return quizRepository.save(quiz);
        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "Quiz_Post",
                    "Quiz", List.of());
        }
    }

    @Override
    public List<Quiz> getbysubjectnameandnumberofday(String subjectName, String numberOfDay) {
        try {

            return quizRepository.findBySubjectNameAndNumberOfDay(subjectName, numberOfDay);
        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "Quiz_Get",
                    "QuizList", List.of());
        }
    }

    @Override
    public int submitQuiz(UserQuizSubmission userQuizSubmission) {
        try {

            int correctAnswer = 0;
            List<AnswerSubmission> answerSubmissionlist = userQuizSubmission.getAnswerSubmissions();
            for (AnswerSubmission answerSubmission : answerSubmissionlist) {
                Optional<Quiz> isCorrect = quizRepository.findBySubjectNameAndNumberOfDayAndIdAndCorrectAnswer(
                        userQuizSubmission.getSubjectName(),
                        userQuizSubmission.getNumberOfDay(),
                        answerSubmission.getQuestionId(),
                        answerSubmission.getSelectedOption());

                if (isCorrect.isPresent()) {
                    correctAnswer++;
                }
            }

            return correctAnswer;
        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "Quiz_Get",
                    "QuizList", List.of());

        }

    }
}
