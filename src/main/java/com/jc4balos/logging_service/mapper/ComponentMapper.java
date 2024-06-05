package com.jc4balos.logging_service.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.jc4balos.logging_service.dto.component.NewComponentDto;
import com.jc4balos.logging_service.model.Component;

public class ComponentMapper {

    @Autowired
    private Component component;

    public ComponentMapper(Component component) {
        this.component = component;
    }

    public Component newComponent(NewComponentDto newComponentDto) {
        component.setComponentName(newComponentDto.getComponentName());
        return component;
    }
}
