package com.edupro.EducationWeb.controller;

import org.springframework.web.bind.annotation.RestController;

import com.edupro.EducationWeb.dto.response.RootResponseModel;
import com.edupro.EducationWeb.entity.AcademicSubject;
import com.edupro.EducationWeb.entity.Course.CourseDetail;
import com.edupro.EducationWeb.entity.Course.CourseIndex;
import com.edupro.EducationWeb.service.CourseService;
import com.edupro.EducationWeb.utils.ResponseOfApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
     @PostMapping("/courseindex/post")
    public ResponseEntity<RootResponseModel<?>> save(@RequestBody CourseIndex   courseIndex) {
        courseService.save(courseIndex);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "CourseIndex_Post",
                "Saved CourseIndex Successfully",
                "CourseIndex",
                List.of());

     
        return ResponseEntity.ok(response);
    }

    @GetMapping("/courseindex/getbysubjectname")
    public ResponseEntity<RootResponseModel<?>> getbysubjectname(@RequestParam String SubjectName) {

        CourseIndex courseIndex= courseService.getbysubjectname(SubjectName);
        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
            true,
            "CourseIndex_Get",
            "Get courseIndex  Successfully",
            "CourseIndex",
            List.of(courseIndex));

 
    return ResponseEntity.ok(response);
    }
    
    @PostMapping("/coursedetail/post")
    public ResponseEntity<RootResponseModel<?>> saveCourseDetail(@RequestBody CourseDetail   CourseDetail) {
        courseService.saveCourseDetail(CourseDetail);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "CourseIndex_Post",
                "Saved CourseDetail Successfully",
                "CourseIndex",
                List.of());

     
        return ResponseEntity.ok(response);
    }

    @GetMapping("/coursedetail/getbyIndexName")
    public ResponseEntity<RootResponseModel<?>> getbyIndexName(@RequestParam String SubjectName ,@RequestParam String TopicName) {

        CourseDetail courseDetail= courseService.getbyIndexName(SubjectName ,TopicName);
        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
            true,
            "CourseIndex_Get",
            "Get courseIndex  Successfully",
            "CourseIndex",
            List.of(courseDetail));

 
    return ResponseEntity.ok(response);
    }

    @GetMapping("/coursedetail/getallbysubjectname")
    public ResponseEntity<RootResponseModel<?>> getallbysubjectname(@RequestParam String SubjectName) {

        List<CourseDetail> courseDetail= courseService.getallbysubjectname(SubjectName);
        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
            true,
            "CourseIndex_Get",
            "Get courseIndex  Successfully",
            "CourseIndex",
            List.of(courseDetail));

 
    return ResponseEntity.ok(response);
    }



    

    


   
    
    
}
