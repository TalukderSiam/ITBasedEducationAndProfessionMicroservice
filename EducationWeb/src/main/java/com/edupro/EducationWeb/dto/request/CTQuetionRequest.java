package com.edupro.EducationWeb.dto.request;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CTQuetionRequest {

    private String subjectName;
    private MultipartFile ctquestionFile;
    private String courseTakenBy;
    private int semester;
    private int year;
}
