package com.jc4balos.logging_service.service.logs.v1;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jc4balos.logging_service.dto.logs.NewLogDto;
import com.jc4balos.logging_service.dto.logs.ViewLogDto;

@Service
public interface LogsService {
    String newLog(NewLogDto newLogDto);

    List<ViewLogDto> getAllLogs(Integer pageIndex, Integer recordsPerPage, Long componentId);
}