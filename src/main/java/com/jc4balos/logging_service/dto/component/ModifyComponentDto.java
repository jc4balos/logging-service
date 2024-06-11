package com.jc4balos.logging_service.dto.component;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ModifyComponentDto {

    @NotEmpty(message = "Component is required.")
    private Long componentId;

    @NotEmpty(message = "Component Name is required.")
    private String componentName;

    @NotEmpty(message = "Must be active or not active.")
    private boolean isActive;

}
