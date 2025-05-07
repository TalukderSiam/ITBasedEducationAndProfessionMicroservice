package com.edupro.EducationWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edupro.EducationWeb.entity.CT.CTQuetion;

public interface CTQuetionRepository extends JpaRepository<CTQuetion, Integer>{

    List<CTQuetion> findBySubjectNameStartingWithIgnoreCase(String subjectName);
    
}
