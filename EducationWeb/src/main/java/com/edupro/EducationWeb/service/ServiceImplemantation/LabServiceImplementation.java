package com.edupro.EducationWeb.service.ServiceImplemantation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edupro.EducationWeb.entity.CT.CTQuetion;
import com.edupro.EducationWeb.entity.LAB.LABDayDetails;
import com.edupro.EducationWeb.entity.LAB.LABSubject;
import com.edupro.EducationWeb.exception.CustomRuntimeException;
import com.edupro.EducationWeb.repository.LAB.LABDayDetailsRepository;
import com.edupro.EducationWeb.repository.LAB.LABSubjectRepository;
import com.edupro.EducationWeb.service.LabService;

@Service
public class LabServiceImplementation implements LabService {

    @Autowired
    private LABSubjectRepository labSubjectRepository;

    @Autowired
    private LABDayDetailsRepository labDayDetailsRepository;

    @Override
    public LABSubject save(LABSubject labSubject) {
        try {
            labSubject.setCreationDate(LocalDateTime.now());
            return labSubjectRepository.save(labSubject);
        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "labSubject_Post",
                    "labSubject", List.of());
        }
    }

    @Override
    public List<LABSubject> getall() {
        try {
            return labSubjectRepository.findAll();
        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "labSubject_Post",
                    "labSubject", List.of());
        }
    }

    // @Override
    // public LABDayDetails save(LABDayDetails lABDayDetails) {
    // try {
    // lABDayDetails.setCreationDate(LocalDateTime.now());
    // return labDayDetailsRepository.save(lABDayDetails);
    // } catch (Exception e) {
    // throw new CustomRuntimeException(false, e.getMessage(), "LABDayDetails_Post",
    // "LABDayDetails", List.of());
    // }

    // }

    @Override
    public List<LABDayDetails> getbysubjectnameandnumberofday(String subjectName, String numberOfDay) {
        try {

            return labDayDetailsRepository.findBySubjectNameAndNumberOfDay(subjectName, numberOfDay);
        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "LABDayDetails_Post",
                    "LABDayDetails", List.of());
        }
    }

    @Override
    public LABDayDetails save(String fileUrl, String labTakenBy, String fileUploadBy, String numberOfDay,
            String subjectName, String indexName) {

        try {

            LABDayDetails labDayDetails = LABDayDetails.builder()
                    .labTakenBy(labTakenBy)
                    .creationDate(LocalDateTime.now())
                    .labFileUrl(fileUrl)
                    .subjectName(subjectName)
                    .fileUploadBy(fileUploadBy)
                    .numberOfDay(numberOfDay)
                    .indexName(indexName)
                    .build();

            return labDayDetailsRepository.save(labDayDetails);

        } catch (Exception e) {

            throw new CustomRuntimeException(false, e.getMessage(), "LABDayDetails_Post",
                    "LABDayDetails", List.of());
        }

    }

}
