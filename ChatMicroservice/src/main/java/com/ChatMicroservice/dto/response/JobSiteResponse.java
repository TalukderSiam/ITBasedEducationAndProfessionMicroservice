package com.ChatMicroservice.dto.response;

import java.util.List;

import com.ChatMicroservice.entity.JobPost;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobSiteResponse {

    private String websiteName;
    private List<JobPost>jobPosts;
    
}
