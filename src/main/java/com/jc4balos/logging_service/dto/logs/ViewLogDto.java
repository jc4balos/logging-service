package com.jc4balos.logging_service.dto.logs;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ViewLogDto {

    private String userName;

    private String eventMessage;

    private LocalDateTime timeStamp;

}
