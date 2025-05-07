package com.edupro.EducationWeb.controller;
import org.springframework.web.bind.annotation.RestController;

import com.edupro.EducationWeb.dto.response.RootResponseModel;
import com.edupro.EducationWeb.entity.CT.CTSubject;
import com.edupro.EducationWeb.service.CTSubjectService;
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
@RequestMapping("/api/ctSubject")
@CrossOrigin(origins = "*")
public class CTSubjectController {

    @Autowired
    private CTSubjectService CTSubjectService;

    @PostMapping("/post")
    public ResponseEntity<RootResponseModel<?>> save(@RequestBody CTSubject   CTSubject) {

       CTSubject ctSubject= CTSubjectService.save(CTSubject);

        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "CTSubject_Post",
                "Saved CTSubject Successfully",
                "CTSubject",
                List.of(ctSubject));

     
        return ResponseEntity.ok(response);
    }








    @GetMapping("getall")
    public ResponseEntity<RootResponseModel<?>> getAllCTSubject() {

       List<CTSubject>CTSubjectList= CTSubjectService.getall();
        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
            true,
            "CTSubject_Get",
            "Get CTSubject List Successfully",
            "CTSubjectList",
            CTSubjectList);

 
    return ResponseEntity.ok(response);
    }
    
}
