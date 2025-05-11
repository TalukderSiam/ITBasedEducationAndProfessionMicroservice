package com.edupro.EducationWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edupro.EducationWeb.entity.Course.CourseDetail;
import com.edupro.EducationWeb.entity.Course.CourseIndex;

public interface CourseDetailRepository extends JpaRepository<CourseDetail, Integer> {

    CourseDetail findBySubjectNameAndTopicName(String subjectName, String topicName);

    List<CourseDetail> findAllBySubjectName(String subjectName);

}
