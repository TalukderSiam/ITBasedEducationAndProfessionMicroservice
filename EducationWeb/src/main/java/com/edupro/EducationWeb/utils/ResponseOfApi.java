package com.edupro.EducationWeb.utils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.edupro.EducationWeb.dto.response.RootResponseModel;



public class ResponseOfApi {


    
   
    
    
    public static RootResponseModel<?> makeRootResponseModelFormate(boolean success ,String messageType  ,String message ,String classType  , List<?> content){
        RootResponseModel<Map<String, List<?>>> response = new RootResponseModel<>();

        response.setSuccess(success);
        if(success){
            response.setMessages(Map.of(messageType, List.of(message)));
            response.setErrorMessages(Map.of());
        }
        else {
            response.setErrorMessages(Map.of(messageType, List.of(message)));
            response.setMessages(Map.of());
        }

         response.setResponseData(Collections.singletonMap(classType, content));
       

        return response;
    
        

    }

}

