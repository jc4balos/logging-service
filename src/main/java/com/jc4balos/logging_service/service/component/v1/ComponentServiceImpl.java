package com.jc4balos.logging_service.service.component.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jc4balos.logging_service.dto.component.NewComponentDto;
import com.jc4balos.logging_service.mapper.ComponentMapper;
import com.jc4balos.logging_service.model.Component;
import com.jc4balos.logging_service.repository.ComponentRepository;

import jakarta.transaction.Transactional;

@Service
public class ComponentServiceImpl implements ComponentService {

    private final ComponentRepository componentRepository;

    private final NewComponentDto newComponentDto;

    @Autowired
    private ComponentMapper componentMapper;

    @Override
    @Transactional // Rollback when something wrong happens
    public String addComponent(NewComponentDto newComponentDto) {
        try {

            Component component = new Component();
            componentMapper.newComponent(newComponentDto)
            // componentRepository.save(component);

        } catch (Exception e) {
            // throw RuntimeException("An error occured. Please contact administrator");
        }

    }
}
