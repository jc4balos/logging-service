package com.jc4balos.logging_service.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.jc4balos.logging_service.exception.ApplicationExceptionHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ControllerService {

    public static ResponseEntity<?> execute(Object obj, BindingResult bindingResult) {
        try {

            if (!bindingResult.hasErrors()) {
                return new ResponseEntity<>(obj,
                        HttpStatus.OK);
            } else {
                return ApplicationExceptionHandler.handleBadRequest(bindingResult);
            }
        } catch (Exception e) {
            return ApplicationExceptionHandler.handleCustomException(e);
        }
    }
}
