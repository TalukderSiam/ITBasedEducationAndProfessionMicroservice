package com.edupro.EducationWeb.service.ServiceImplemantation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edupro.EducationWeb.entity.AcademicSubject;
import com.edupro.EducationWeb.exception.CustomRuntimeException;
import com.edupro.EducationWeb.repository.AcademicSubjectRepository;
import com.edupro.EducationWeb.service.AcademicSubjectService;
@Service
public class AcademicSubjectServiceImplementation  implements AcademicSubjectService{
    @Autowired
    private AcademicSubjectRepository academicSubjectRepository;
    @Override
    public void save(AcademicSubject academicSubject) {
       
      try {
        System.out.println("siam");
        academicSubjectRepository.save(academicSubject);

      } catch (Exception e) {
        
      }
    }
    @Override
    public List<AcademicSubject> getall() {
       try {
       return academicSubjectRepository.findAll();
       } catch (Exception e) {
       return List.of();
       }
    }
    @Override
    public List<AcademicSubject> getBySubjectName(String subjectName) {
     try {
      if (subjectName == null || subjectName.trim().isEmpty()) {
        return academicSubjectRepository.findAll();
    }
    return academicSubjectRepository.findBySubjectNameStartingWithIgnoreCase(subjectName);
      
     } catch (Exception e) {
      
            throw new CustomRuntimeException(false, e.getMessage(), "AcademicSubject_Post",
                    "AcademicSubject", List.of());
     }
    }
    
}
