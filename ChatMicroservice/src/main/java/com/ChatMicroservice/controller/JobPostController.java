package com.ChatMicroservice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ChatMicroservice.dto.response.JobSiteResponse;
import com.ChatMicroservice.dto.response.RootResponseModel;
import com.ChatMicroservice.utils.ResponseOfApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ChatMicroservice.service.JobPostService;


@RestController
@RequestMapping("/api/jobpost")
@CrossOrigin("*")
public class JobPostController {
    @Autowired
    private JobPostService JobPostService;

    @GetMapping("/getjobpostbywebscrape")
    public ResponseEntity<RootResponseModel<?>> getjobpostbywebscrape() {
        
       List<JobSiteResponse> jobSiteResponse= JobPostService.getAllJobPosts();

         RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                true,
                "Interview_Post",
                "Saved Interview Successfully",
                "Interview",
                List.of(jobSiteResponse));

     
        return ResponseEntity.ok(response);

    }

}
