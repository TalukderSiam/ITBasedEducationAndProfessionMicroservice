package com.edupro.EducationWeb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edupro.EducationWeb.service.DeviceConfigurationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edupro.EducationWeb.dto.request.Response;
import com.edupro.EducationWeb.dto.response.ApiResponse;
import com.edupro.EducationWeb.entity.DeviceConfiguration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/deviceRecommand")
public class PageRecommandationController {
     
    @Autowired
    private DeviceConfigurationService deviceConfigurationService;
   @PostMapping("/saveDeviceConfiguration")
public ResponseEntity<Response> saveDeviceConfiguration(@RequestBody DeviceConfiguration deviceConfiguration) {
  
        Response response = deviceConfigurationService.saveDeviceConfiguration(deviceConfiguration);
        return new ResponseEntity<>(response, HttpStatus.CREATED); // Use CREATED for new resource creation
    
}



  @GetMapping("/getMinimumConfiguration")
  public ResponseEntity<ApiResponse<DeviceConfiguration>> getMinimumConfiguration() {
    ApiResponse<DeviceConfiguration> response =  deviceConfigurationService.getMinimumConfiguration();
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }
  

    
    
}
