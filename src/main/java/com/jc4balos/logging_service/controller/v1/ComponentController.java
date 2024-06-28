package com.jc4balos.logging_service.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jc4balos.logging_service.dto.component.ModifyComponentDto;
import com.jc4balos.logging_service.dto.component.NewComponentDto;
import com.jc4balos.logging_service.exception.ApplicationExceptionHandler;
import com.jc4balos.logging_service.service.component.v1.ComponentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


/*
 * This Controller manipulates all the microservices components of an application.
 * A component is a single microservice in the server.
 */

@RestController
@RequestMapping("api/v1/logs/component")
@RequiredArgsConstructor
public class ComponentController {

    @Autowired
    private ComponentService componentService;

    @PostMapping("/add")
    public ResponseEntity<?> addComponent(@Valid @RequestBody NewComponentDto newComponent,
            BindingResult bindingResult) {
        try {
            if (!bindingResult.hasErrors()) {
                return new ResponseEntity<>(componentService.addComponent(newComponent),
                        HttpStatus.OK);
            } else {
                return ApplicationExceptionHandler.handleBadRequest(bindingResult);
            }
        } catch (Exception e) {
            return ApplicationExceptionHandler.handleCustomException(e);
        }
    }

    @PatchMapping("/modify")
    public ResponseEntity<?> addComponent(@Valid @RequestBody ModifyComponentDto component,
            BindingResult bindingResult) {
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

    // TODO: Add delete component
    @PatchMapping("/delete")
    public ResponseEntity<?> deleteComponent(@RequestParam Long componentId){

        
        return null;
    }
}
