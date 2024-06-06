package com.jc4balos.logging_service.service.component.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jc4balos.logging_service.dto.component.NewComponentDto;
import com.jc4balos.logging_service.mapper.ComponentMapper;
import com.jc4balos.logging_service.model.ServiceComponent;
import com.jc4balos.logging_service.repository.ComponentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComponentServiceImpl implements ComponentService {

    private final ComponentRepository componentRepository;

    @Autowired
    private ComponentMapper componentMapper;

    @Override
    @Transactional // Rollback when something wrong happens
    public String addComponent(NewComponentDto componentDto) {
        try {
            ServiceComponent componentToSave = componentMapper.newComponent(componentDto);
            componentRepository.save(componentToSave);
            return componentToSave.getComponentName().toString() + " component sucessfully added.";

        } catch (Exception e) {
            throw new RuntimeException("An error occured when saving a new component");
        }

    }
}
