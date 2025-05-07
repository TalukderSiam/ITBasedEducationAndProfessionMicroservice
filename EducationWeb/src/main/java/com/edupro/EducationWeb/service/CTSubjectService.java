package com.edupro.EducationWeb.service;

import java.util.List;

import com.edupro.EducationWeb.entity.CT.CTSubject;

public interface CTSubjectService {

	CTSubject save(CTSubject cTSubject);

    List<CTSubject> getall();
    
}
