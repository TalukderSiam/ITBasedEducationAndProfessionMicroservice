package com.edupro.EducationWeb.service.ServiceImplemantation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.edupro.EducationWeb.entity.CT.CTQuetion;
import com.edupro.EducationWeb.exception.CustomRuntimeException;
import com.edupro.EducationWeb.repository.CTQuetionRepository;
import com.edupro.EducationWeb.service.CTQuetionService;

@Service
public class CTQuetionServiceImplementation implements CTQuetionService {

    @Autowired
    private CTQuetionRepository ctQuetionRepository;

    @Override
    public CTQuetion save(String fileUrl, String courseTakenBy, String semester, String year,String subjectName) {
       try {

        CTQuetion ctQuetion = CTQuetion.builder()
        .courseTakenBy(courseTakenBy)
        .creationDate(LocalDate.now())
        .ctquestionFileUrl(fileUrl)
        .subjectName(subjectName)
        .year(year)
        .semester(semester)
        .build();

        return ctQuetionRepository.save(ctQuetion);
        
       } catch (Exception e) {

       throw new CustomRuntimeException(false, e.getMessage(), "CTQuetion_Post",
        "CTQuetion", List.of());
       }
    }

    @Override
    public List<CTQuetion> getBySubjectName(String subjectName) {
        try {
            
          return ctQuetionRepository.findBySubjectNameStartingWithIgnoreCase(subjectName);
            
           } catch (Exception e) {
            
                  throw new CustomRuntimeException(false, e.getMessage(), "CTQuetion_Get",
                          "CTQuetion", List.of());
           }
    }


   
       
    
}

