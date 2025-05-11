package com.edupro.EducationWeb.repository.LAB;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edupro.EducationWeb.entity.CT.CTSubject;
import com.edupro.EducationWeb.entity.Course.CourseDetail;
import com.edupro.EducationWeb.entity.LAB.LABSubject;

public interface LABSubjectRepository extends JpaRepository<LABSubject, Integer>{
    
}
