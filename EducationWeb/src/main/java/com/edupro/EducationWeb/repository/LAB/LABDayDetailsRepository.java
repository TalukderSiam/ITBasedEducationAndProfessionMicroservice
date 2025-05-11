package com.edupro.EducationWeb.repository.LAB;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edupro.EducationWeb.entity.LAB.LABDayDetails;
import com.edupro.EducationWeb.entity.LAB.LABQuetion;

public interface LABDayDetailsRepository extends JpaRepository<LABDayDetails, Integer>{

    List<LABDayDetails> findBySubjectNameAndNumberOfDay(String subjectName, String numberOfDay);
    
}
