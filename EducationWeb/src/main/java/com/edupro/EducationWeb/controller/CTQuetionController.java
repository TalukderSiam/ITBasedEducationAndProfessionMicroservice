package com.edupro.EducationWeb.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.edupro.EducationWeb.dto.response.RootResponseModel;
import com.edupro.EducationWeb.entity.CT.CTQuetion;
import com.edupro.EducationWeb.entity.CT.CTSubject;
import com.edupro.EducationWeb.service.CTQuetionService;
import com.edupro.EducationWeb.service.CTSubjectService;
import com.edupro.EducationWeb.service.CloudinaryService;
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
@RequestMapping("/api/ctquetion")
@CrossOrigin(origins = "*")
public class CTQuetionController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private CTQuetionService  cTQuetionService;

    @PostMapping("/post")
    public ResponseEntity<RootResponseModel<?>> uploadCTQuestion(
            @RequestParam("ctquestionFile") MultipartFile file,
            @RequestParam("courseTakenBy") String courseTakenBy,
            @RequestParam("semester") String semester,
            @RequestParam("year") String year,
            @RequestParam("subjectName") String subjectName
    ) {
        
            String fileUrl = cloudinaryService.uploadFile(file);

            CTQuetion question =cTQuetionService.save(fileUrl,courseTakenBy,semester,year,subjectName);

            RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "CTQuestion_Get",
                "Get CTQuestion List Successfully",
                "CTQuestion",
                List.of(question));
    
     
        return ResponseEntity.ok(response);

         
    }


    @GetMapping("getbysubjectname")
    public ResponseEntity<RootResponseModel<?>> getBySubjectName(@RequestParam String SubjectName) {

       List<CTQuetion>CTQuetionList= cTQuetionService.getBySubjectName(SubjectName);
        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
            true,
            "CTQuetion_Get",
            "Get CTQuetion List Successfully",
            "CTQuetionList",
            CTQuetionList);

 
    return ResponseEntity.ok(response);
    }


}
    

