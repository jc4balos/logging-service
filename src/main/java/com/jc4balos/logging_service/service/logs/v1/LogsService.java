package com.jc4balos.logging_service.service.logs.v1;

import org.springframework.stereotype.Service;

import com.jc4balos.logging_service.dto.logs.NewLogDto;

@Service
public interface LogsService {
    String newLog(NewLogDto newLogDto);
}