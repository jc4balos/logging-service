package com.jc4balos.logging_service.service.logs.v1;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jc4balos.logging_service.dto.logs.NewLogDto;
import com.jc4balos.logging_service.dto.logs.ViewLogDto;
import com.jc4balos.logging_service.mapper.LogsMapper;
import com.jc4balos.logging_service.model.Logs;
import com.jc4balos.logging_service.repository.LogsRepository;
import com.jc4balos.logging_service.service.component.v1.ComponentServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogsServiceImpl implements LogsService {

    private final LogsRepository logsRepository;

    private final Logger logger = LoggerFactory.getLogger(ComponentServiceImpl.class);

    @Autowired
    private final LogsMapper logsMapper;

    @Override
    public String newLog(NewLogDto newLogDto) {
        Logs newLog = logsMapper.newLog(newLogDto);
        logsRepository.save(newLog);
        String componentName = newLog.getServiceComponent().getComponentName();
        String responseMessage = "Added log:" + " [" + componentName + "] " + newLog.getUserName() + " "
                + newLog.getEvent();
        logger.info(responseMessage);
        return responseMessage;
    }

    @Override
    public List<ViewLogDto> getAllLogs(Integer pageIndex, Integer recordsPerPage, Long componentId) {
        Pageable pageAndSort = PageRequest.of(pageIndex, recordsPerPage, Sort.by("time_stamp").descending());
        Page<Logs> allLogs = logsRepository.findByComponentId(componentId, pageAndSort);
        Page<ViewLogDto> viewLogsDto = allLogs.map(log -> logsMapper.viewLog(log));
        return viewLogsDto.getContent();
    }

}
