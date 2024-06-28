package com.jc4balos.logging_service.service.component.v1;

import org.springframework.stereotype.Service;

import com.jc4balos.logging_service.dto.component.ModifyComponentDto;
import com.jc4balos.logging_service.dto.component.NewComponentDto;

@Service
public interface ComponentService {

    String addComponent(NewComponentDto newComponentDto);

    String modifyComponent(ModifyComponentDto componentDto);

    String deleteComponent(Long componentId);

}