package com.jc4balos.logging_service.mapper;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jc4balos.logging_service.dto.logs.NewLogDto;
import com.jc4balos.logging_service.dto.logs.ViewLogDto;
import com.jc4balos.logging_service.model.Logs;
import com.jc4balos.logging_service.model.ServiceComponent;
import com.jc4balos.logging_service.repository.ServiceComponentRepository;
import com.jc4balos.logging_service.service.component.v1.ComponentServiceImpl;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LogsMapper {

    @Autowired
    private Logs logs;

    @Autowired
    private ViewLogDto viewLogDto;

    @Autowired
    private ServiceComponent serviceComponent;

    private final ServiceComponentRepository serviceComponentRepository;

    private final Logger logger = LoggerFactory.getLogger(ComponentServiceImpl.class);

    public Logs newLog(NewLogDto newLogDto) {
        Optional<ServiceComponent> logServiceComponent = serviceComponentRepository
                .findById(newLogDto.getComponentId());
        if (!logServiceComponent.isPresent()) {
            String responseMessage = "Component not found.";
            logger.error(responseMessage);
            throw new RuntimeException(responseMessage);
        }
        logs.setServiceComponent(logServiceComponent.get());
        logs.setEvent(newLogDto.getEventMessage());
        logs.setUserName(newLogDto.getUserName());
        return logs;
    }

    public ViewLogDto viewLog(Logs log) {
        viewLogDto.setEventMessage(log.getEvent());
        viewLogDto.setTimeStamp(log.getTimeStamp());
        viewLogDto.setUserName(log.getUserName());
        return viewLogDto;
    }

}
