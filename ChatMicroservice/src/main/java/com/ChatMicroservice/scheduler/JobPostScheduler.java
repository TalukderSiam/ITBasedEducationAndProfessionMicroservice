package com.ChatMicroservice.scheduler;

import java.util.List;

import org.hibernate.cfg.Compatibility;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ChatMicroservice.dto.response.JobSiteResponse;
import com.ChatMicroservice.entity.JobPost;
import com.ChatMicroservice.service.JobPostService;

@Component

public class JobPostScheduler {

      private final JobPostService jobScraperService;;

    public JobPostScheduler(JobPostService jobScraperService) {
        this.jobScraperService = jobScraperService;
    }

    //@Scheduled(cron = "0 0 * * * ?") // every hour
    // @Scheduled(cron = "*/2 * * * * *") // every 2 seconds
    @Scheduled(cron = "0 0 8 * * *")
    public void fetchJobsRegularly() {
        List<JobSiteResponse> jobs = jobScraperService.getAllJobPosts();
        // Save to DB or cache
    }
}


