package com.edupro.EducationWeb.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import com.cloudinary.*;
import org.springframework.context.annotation.Bean;

@Configuration
public class CloudinarycloudinaryConfig {

    @Bean
    public Cloudinary  getCloudinar(){
        Map cloudinaryConfig = new HashMap();
        cloudinaryConfig.put("cloud_name", "dguzsdxok");
        cloudinaryConfig.put("api_key", "892939795265749");
        cloudinaryConfig.put("api_secret", "nQcnsvLhLAsACbeaBYelArtEPI4");

        return new Cloudinary(cloudinaryConfig);
    }
}
