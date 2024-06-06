package com.jc4balos.logging_service.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc4balos.logging_service.dto.component.NewComponentDto;
import com.jc4balos.logging_service.service.component.v1.ComponentService;
import com.jc4balos.logging_service.utils.ControllerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/logs/component")
@RequiredArgsConstructor
public class ComponentController {

    @Autowired
    private ComponentService componentService;

    @PostMapping("/add")
    public ResponseEntity<?> addComponent(@Valid @RequestBody NewComponentDto newComponent,
            BindingResult bindingResult) {
        return ControllerService.execute(componentService.addComponent(newComponent), bindingResult);
    }

}
