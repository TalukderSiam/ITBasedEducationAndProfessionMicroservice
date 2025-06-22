package com.ChatMicroservice.service;

import java.util.List;

import com.ChatMicroservice.dto.response.JobSiteResponse;

public interface JobPostService {

    List<JobSiteResponse> getAllJobPosts();

    
} 