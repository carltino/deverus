package com.example.deverus.linkedin.manageprofile.api;

import com.example.deverus.linkedin.manageprofile.exception.ProfileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProfileControllerAdvice {

    @ExceptionHandler(ProfileNotFoundException.class)
    public ResponseEntity handleCityNotFoundException(
            ProfileNotFoundException ex ) {

        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
}
