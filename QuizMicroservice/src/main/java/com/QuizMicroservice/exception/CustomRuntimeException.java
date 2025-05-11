package com.QuizMicroservice.exception;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomRuntimeException extends RuntimeException {
    private  boolean success;
    private String message;
    private  String messageType;
    private  String classType;
    private  List<?> content;
}
