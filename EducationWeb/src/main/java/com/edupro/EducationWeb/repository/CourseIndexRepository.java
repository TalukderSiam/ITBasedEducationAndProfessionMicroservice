package com.edupro.EducationWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edupro.EducationWeb.entity.Course.CourseIndex;

@Repository
public interface CourseIndexRepository extends JpaRepository<CourseIndex, Integer> {

    
    CourseIndex findBysubjectName(String subjectName);

    // @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM CourseIndex c WHERE c.subjectName = :subjectName AND :index IN c.indexList")
    // boolean exitsIndexForSubject(String subjectName, String topicName);
    
}
