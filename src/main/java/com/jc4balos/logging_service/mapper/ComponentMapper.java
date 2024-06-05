package com.jc4balos.logging_service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jc4balos.logging_service.dto.component.NewComponentDto;
import com.jc4balos.logging_service.model.ServiceComponent;

@Component
public class ComponentMapper {

    @Autowired
    private ServiceComponent serviceComponent;

    public ComponentMapper(ServiceComponent serviceComponent) {
        this.serviceComponent = serviceComponent;
    }

    public ServiceComponent newComponent(NewComponentDto newComponentDto) {
        serviceComponent.setComponentName(newComponentDto.getComponentName());
        return serviceComponent;
    }
}
