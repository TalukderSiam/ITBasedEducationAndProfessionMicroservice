
package com.Quiz.Quiz.Microservice.repository;


import com.Quiz.Quiz.Microservice.entity.Quiz; // ✅ Missing import added
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
