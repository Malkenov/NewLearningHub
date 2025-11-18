package com.example.LearningHub.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter
@Getter
public class ErrorResponse {

    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime dateTime;

    public ErrorResponse(HttpStatus httpStatus,String message){
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
