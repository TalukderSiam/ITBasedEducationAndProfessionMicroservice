package com.edupro.EducationWeb.service;

import java.util.List;

import com.edupro.EducationWeb.entity.AcademicSubject;

public interface AcademicSubjectService {

    void save(AcademicSubject academicSubject);

    List<AcademicSubject> getall();

    List<AcademicSubject> getBySubjectName(String subjectName);
    
}
