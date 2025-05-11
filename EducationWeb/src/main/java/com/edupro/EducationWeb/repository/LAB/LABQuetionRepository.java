package com.edupro.EducationWeb.repository.LAB;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edupro.EducationWeb.entity.CT.CTQuetion;
import com.edupro.EducationWeb.entity.LAB.LABQuetion;

public interface LABQuetionRepository extends JpaRepository<LABQuetion, Integer>{

    List<LABQuetion> findBySubjectNameStartingWithIgnoreCase(String subjectName);
    
}
