package com.edupro.EducationWeb.service.ServiceImplemantation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edupro.EducationWeb.entity.CT.CTSubject;
import com.edupro.EducationWeb.exception.CustomRuntimeException;
import com.edupro.EducationWeb.repository.CTSubjectRepository;
import com.edupro.EducationWeb.service.CTSubjectService;

@Service
public class CTSubjectServiceImplement implements CTSubjectService {

    @Autowired
    private CTSubjectRepository ctSubjectRepository;


	@Override
	public CTSubject save(CTSubject ctSubject) {
		try {
            ctSubject.setCreationDate(LocalDateTime.now());
            return ctSubjectRepository.save(ctSubject);
        } catch (Exception e) {
           throw new CustomRuntimeException(false, e.getMessage(), "CTSubject_Post",
                    "CTSubject", List.of());
        }
	}

    @Override
    public List<CTSubject> getall() {
       try {
       return ctSubjectRepository.findAll();
       } catch (Exception e) {
        throw new CustomRuntimeException(false, e.getMessage(), "CTSubject_Post",
        "CTSubject", List.of());
       }
    }
    
}
