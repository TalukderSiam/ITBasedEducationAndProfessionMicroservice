package com.edupro.EducationWeb.repository;

import com.edupro.EducationWeb.entity.AcademicSubject;
import com.edupro.EducationWeb.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface AcademicSubjectRepository extends JpaRepository<AcademicSubject, Integer>{

    List<AcademicSubject> findBySubjectNameStartingWithIgnoreCase(String subjectName);
    
}
