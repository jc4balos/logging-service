package com.jc4balos.logging_service.controller.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc4balos.logging_service.dto.component.NewComponentDto;

@RestController
@RequestMapping("api/v1/logs")
public class ComponentController {

    @PostMapping("/add-component")
    public ResponseEntity<?> addComponent(@RequestBody NewComponentDto newComponent) {
        // TODO: make a component service and implement addcomponent()
        return null;
    }

}
