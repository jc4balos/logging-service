package com.jc4balos.logging_service.service.component.v1;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jc4balos.logging_service.dto.component.ModifyComponentDto;
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

    private final Logger logger = LoggerFactory.getLogger(ComponentServiceImpl.class);

    @Autowired
    private ComponentMapper componentMapper;

    @Override
    @Transactional // Rollback when something wrong happens
    public String addComponent(NewComponentDto componentDto) {
        try {
            ServiceComponent componentToSave = componentMapper.newComponent(componentDto);
            componentRepository.save(componentToSave);
            String responseMessage = componentToSave.getComponentName().toString() + " component successfully added.";
            logger.info(responseMessage);
            return responseMessage;
        } catch (DataIntegrityViolationException e) {
            logger.error("Component name already exists: " + componentDto.getComponentName());
            throw new IllegalArgumentException("Component name already exists: " + componentDto.getComponentName());
        } catch (Exception e) {
            logger.error("An error occured in addding a component: " + e);
            throw e;
        }
    }

    @Override
    @Transactional // Rollback when something wrong happens
    public String modifyComponent(ModifyComponentDto componentDto) {
        Optional<ServiceComponent> existingComponent = componentRepository.findById(componentDto.getComponentId());
        if (!existingComponent.isPresent()) {
            String responseMessage = componentDto.getComponentName() + " component not found.";
            logger.error(responseMessage);
            throw new RuntimeException(responseMessage);
        }

        try {
            ServiceComponent componentToSave = componentMapper.modifyComponent(existingComponent.get(), componentDto);
            componentRepository.save(componentToSave);
            String responseMessage = componentToSave.getComponentName() + " component successfully modified.";
            logger.info(responseMessage);
            return responseMessage;
        } catch (DataIntegrityViolationException e) {
            logger.error("Component name already exists: " + componentDto.getComponentName());
            throw new RuntimeException("Component name already exists: " + componentDto.getComponentName());
        } catch (Exception e) {
            String responseMessage = "An error while modifying a component: " + e;
            logger.error(responseMessage);
            throw new RuntimeException(responseMessage);
        }
    }
}