package com.edupro.EducationWeb.service;

import java.util.List;

import com.edupro.EducationWeb.entity.CT.CTQuetion;

public interface CTQuetionService {

    CTQuetion save(String fileUrl, String courseTakenBy, String semester, String year,String subjectName);

    List<CTQuetion> getBySubjectName(String subjectName);
    
}
