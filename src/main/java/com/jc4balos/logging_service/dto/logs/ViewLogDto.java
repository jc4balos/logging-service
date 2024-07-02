package com.jc4balos.logging_service.dto.logs;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ViewLogDto {

    private String userName;

    private String eventMessage;

    private LocalDateTime timeStamp;

}
