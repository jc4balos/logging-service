package com.jc4balos.logging_service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jc4balos.logging_service.dto.component.ModifyComponentDto;
import com.jc4balos.logging_service.dto.component.NewComponentDto;
import com.jc4balos.logging_service.model.ServiceComponent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ComponentMapper {

    @Autowired
    private ServiceComponent serviceComponent;

    public ServiceComponent newComponent(NewComponentDto newComponentDto) {
        serviceComponent.setComponentName(newComponentDto.getComponentName());
        serviceComponent.setActive(true);
        return serviceComponent;
    }

    public ServiceComponent modifyComponent(ServiceComponent component,
            ModifyComponentDto modifyComponentDto) {
        component.setComponentName(modifyComponentDto.getComponentName());
        component.setActive(modifyComponentDto.isActive());
        return serviceComponent;
    }
}
