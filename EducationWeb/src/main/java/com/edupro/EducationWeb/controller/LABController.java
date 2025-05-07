package com.edupro.EducationWeb.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.edupro.EducationWeb.dto.response.RootResponseModel;
import com.edupro.EducationWeb.entity.CT.CTQuetion;
import com.edupro.EducationWeb.entity.LAB.LABDayDetails;
import com.edupro.EducationWeb.entity.LAB.LABSubject;
import com.edupro.EducationWeb.service.CloudinaryService;
import com.edupro.EducationWeb.service.LabService;
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
@RequestMapping("/api/lab")
@CrossOrigin(origins = "*")
public class LABController {

    @Autowired
    private LabService LabService;

    @Autowired
    private CloudinaryService cloudinaryService;

    

    @PostMapping("labsubject/post")
    public ResponseEntity<RootResponseModel<?>> save(@RequestBody LABSubject   LabSubject) {

        LABSubject savedLabSubject= LabService.save(LabSubject);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "LabSubject_Post",
                "Saved LabSubject Successfully",
                "LABSubject",
                List.of(savedLabSubject));

     
        return ResponseEntity.ok(response);
    }








    @GetMapping("labsubject/getall")
    public ResponseEntity<RootResponseModel<?>> getAllLabSubject() {

       List<LABSubject>LabSubjectList= LabService.getall();
        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
            true,
            "LabSubject_Get",
            "Get LabSubject List Successfully",
            "LabSubjectList",
            LabSubjectList);

 
    return ResponseEntity.ok(response);
    }

    @PostMapping("labdaydetails/post")
    public ResponseEntity<RootResponseModel<?>> save( 
    @RequestParam("LabQuestionFile") MultipartFile file,
    @RequestParam("LabTakenBy") String labTakenBy,
    @RequestParam("FileUploadBy") String fileUploadBy,
    @RequestParam("NumberOfDay") String numberOfDay,
    @RequestParam("SubjectName") String subjectName,
    @RequestParam("IndexName") String indexName) {

        String fileUrl = cloudinaryService.uploadFile(file);

          //  CTQuetion question =cTQuetionService.save(fileUrl,courseTakenBy,semester,year,subjectName);

        LABDayDetails savedLABDayDetails= LabService.save(fileUrl,labTakenBy,fileUploadBy,numberOfDay,subjectName,indexName);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "LabSubject_Post",
                "Saved LabSubject Successfully",
                "LABSubject",
                List.of(savedLABDayDetails));

     
        return ResponseEntity.ok(response);
    }

    @GetMapping("labdaydetails/getbysubjectnameandnumberofday")
    public ResponseEntity<RootResponseModel<?>> getbysubjectnameandnumberofday(@RequestParam String SubjectName , @RequestParam String NumberOfDay) {

        List<LABDayDetails> savedLABDayDetails= LabService.getbysubjectnameandnumberofday(SubjectName,NumberOfDay);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "LabSubject_Post",
                "Saved LabSubject Successfully",
                "LABSubject",
                List.of(savedLABDayDetails));

     
        return ResponseEntity.ok(response);
    }



    
}
