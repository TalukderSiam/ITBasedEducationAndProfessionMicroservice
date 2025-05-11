package com.edupro.EducationWeb.service.ServiceImplemantation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edupro.EducationWeb.entity.Course.CourseDetail;
import com.edupro.EducationWeb.entity.Course.CourseIndex;
import com.edupro.EducationWeb.repository.CourseDetailRepository;
import com.edupro.EducationWeb.repository.CourseIndexRepository;
import com.edupro.EducationWeb.service.CourseService;

@Service
public class CourseServiceImplementation implements CourseService {

   @Autowired
   private CourseIndexRepository courseIndexRepository;
   @Autowired
   private CourseDetailRepository courseDetailRepository;

   @Override
   public void save(CourseIndex courseIndex) {
      try {
         courseIndexRepository.save(courseIndex);
      } catch (Exception e) {

      }
   }

   @Override
   public CourseIndex getbysubjectname(String subjectName) {
      try {
         return courseIndexRepository.findBysubjectName(subjectName);
      } catch (Exception e) {
         return new CourseIndex();
      }
   }

   @Override
   public void saveCourseDetail(CourseDetail CourseDetail) {
      try {
         courseDetailRepository.save(CourseDetail);
      } catch (Exception e) {

      }
   }

   @Override
   public CourseDetail getbyIndexName(String subjectName, String topicName) {
      // boolean isExitsIndexForSubject =
      // courseIndexRepository.exitsIndexForSubject(subjectName,topicName);
      try {

         CourseDetail courseDetail = courseDetailRepository.findBySubjectNameAndTopicName(subjectName, topicName);
         return courseDetail;
      } catch (Exception e) {
         return new CourseDetail();
      }

   }

   @Override
   public List<CourseDetail> getallbysubjectname(String subjectName) {
     try {
      List<CourseDetail> courseDetails=courseDetailRepository.findAllBySubjectName(subjectName);
      return courseDetails;
     } catch (Exception e) {
      return List.of();
     }
   }
}
