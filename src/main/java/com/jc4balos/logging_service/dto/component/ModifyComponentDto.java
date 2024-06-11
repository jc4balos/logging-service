package com.jc4balos.logging_service.dto.component;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModifyComponentDto {
    @NotNull(message = "Component is required.")
    private Long componentId;

    @NotNull(message = "Component Name is required.")
    private String componentName;

    @NotNull(message = "Must be active or not active.")
    private boolean isActive;
}
