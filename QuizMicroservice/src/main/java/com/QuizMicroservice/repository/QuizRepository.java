
package com.QuizMicroservice.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizMicroservice.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    List<Quiz> findBySubjectNameAndNumberOfDay(String subjectName, String numberOfDay);
}
