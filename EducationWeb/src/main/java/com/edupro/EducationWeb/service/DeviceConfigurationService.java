package com.edupro.EducationWeb.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edupro.EducationWeb.dto.request.Response;
import com.edupro.EducationWeb.dto.response.ApiResponse;
import com.edupro.EducationWeb.entity.DeviceConfiguration;
import com.edupro.EducationWeb.repository.saveDeviceConfigurationRepository;
@Service
public class DeviceConfigurationService {
    
    @Autowired
    private saveDeviceConfigurationRepository  saveDeviceConfigurationRepository;
    Response response = new Response();

    public Response saveDeviceConfiguration(DeviceConfiguration deviceConfiguration ){
        saveDeviceConfigurationRepository.save(deviceConfiguration);
        response.setStatus(201);
        response.setMessage("Save device configuration Successfull");
        return response;

    }

   public ApiResponse<DeviceConfiguration> getMinimumConfiguration(){
    List<DeviceConfiguration> configurations = saveDeviceConfigurationRepository.findAll();
    return new ApiResponse<>(
        "200", // HTTP OK
        "Configurations retrieved successfully.",
        configurations
);
   }
}
