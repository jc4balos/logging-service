package com.jc4balos.logging_service.controller.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/logs")
public class ComponentController {

    @PostMapping("/add-component")
    public ResponseEntity<?> addComponent(@RequestParam String componentName) {
        // TODO: make a component service and implement addcomponent()
        // return entity;
    }

}
