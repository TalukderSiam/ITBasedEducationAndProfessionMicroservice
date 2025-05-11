package com.ChatMicroservice.exception;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ChatMicroservice.dto.response.RootResponseModel;
import com.ChatMicroservice.utils.ResponseOfApi;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
// @Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity<RootResponseModel<?>> handleCustomRuntimeException(CustomRuntimeException ex) {
        // log.error("Exception Start : xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx ");
        // log.error("Exception Exception : ", ex);
        // log.error("Exception Finish : xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                ex.isSuccess(),
                ex.getMessageType(),
                ex.getMessage(),
                ex.getClassType(),
                ex.getContent());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RootResponseModel<?>> handleGenericException(Exception ex) {
        RootResponseModel<?> response = ResponseOfApi.makeRootResponseModelFormate(
                false,
                "error",
                ex.getMessage(),
                "GenericException",
                List.of());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
