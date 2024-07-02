package com.jc4balos.logging_service.service.logs.v1;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jc4balos.logging_service.dto.logs.NewLogDto;
import com.jc4balos.logging_service.dto.logs.ViewLogDto;

@Service
public interface LogsService {
    String newLog(NewLogDto newLogDto);

    Page<ViewLogDto> getAllLogs(Integer pageIndex, Integer recordsPerPage, Long componentId);
}