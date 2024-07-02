package com.jc4balos.logging_service.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jc4balos.logging_service.dto.logs.NewLogDto;
import com.jc4balos.logging_service.exception.ApplicationExceptionHandler;
import com.jc4balos.logging_service.service.logs.v1.LogsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/logs")
@RequiredArgsConstructor
public class LogsController {

    @Autowired
    private LogsService logsService;

    @PostMapping("/add")
    public ResponseEntity<?> addLogs(@RequestBody NewLogDto newlogDto, BindingResult bindingResult) {
        try {
            if (!bindingResult.hasErrors()) {
                return new ResponseEntity<>(logsService.newLog(newlogDto),
                        HttpStatus.OK);
            } else {
                return ApplicationExceptionHandler.handleBadRequest(bindingResult);
            }
        } catch (Exception e) {
            return ApplicationExceptionHandler.handleCustomException(e);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllLogs(@RequestParam Integer pageIndex,
            @RequestParam Integer recordsPerPage, @PathVariable Long componentId) {

        try {
            return new ResponseEntity<>(logsService.getAllLogs(pageIndex, recordsPerPage, componentId),
                    HttpStatus.OK);

        } catch (Exception e) {
            return ApplicationExceptionHandler.handleCustomException(e);
        }
    }

}
