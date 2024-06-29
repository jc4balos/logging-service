package com.jc4balos.logging_service.controller.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc4balos.logging_service.dto.logs.AddLogsDto;
import com.jc4balos.logging_service.exception.ApplicationExceptionHandler;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/logs")
@RequiredArgsConstructor
public class LogsController {

    @PostMapping("path")
    public ResponseEntity<?> addLogs(@RequestBody AddLogsDto addLogsDto, BindingResult bindingResult) {
        try {
            if (!bindingResult.hasErrors()) {
                return new ResponseEntity<>(componentService.modifyComponent(component),
                        HttpStatus.OK);
            } else {
                return ApplicationExceptionHandler.handleBadRequest(bindingResult);
            }
        } catch (Exception e) {
            return ApplicationExceptionHandler.handleCustomException(e);
        }
    }

}
