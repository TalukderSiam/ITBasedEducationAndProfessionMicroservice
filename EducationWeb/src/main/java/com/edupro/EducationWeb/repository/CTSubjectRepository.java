package com.edupro.EducationWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edupro.EducationWeb.entity.CT.CTSubject;
import com.edupro.EducationWeb.entity.Course.CourseDetail;

public interface CTSubjectRepository extends JpaRepository<CTSubject, Integer>{
    
}
