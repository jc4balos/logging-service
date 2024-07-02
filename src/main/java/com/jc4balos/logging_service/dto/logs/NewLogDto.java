package com.jc4balos.logging_service.dto.logs;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class NewLogDto {

    @NotEmpty(message = "Component is required.")
    private Long componentId;

    @NotEmpty(message = "Username is required.")
    private String userName;

    @NotEmpty(message = "Event message is required")
    private String eventMessage;

}
