package com.jc4balos.logging_service.dto.logs;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AddLogsDto {

    @NotEmpty(message = "Component is required.")
    private Long componentId;

    @NotEmpty(message = "User is required.")
    private Long userId;

    @NotEmpty(message = "Event message is required")
    private String eventMessage;

}
