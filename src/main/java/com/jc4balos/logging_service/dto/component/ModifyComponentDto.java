package com.jc4balos.logging_service.dto.component;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModifyComponentDto {
    @NotNull(message = "Component is required.")
    private Long componentId;

    @NotEmpty(message = "Component Name is required.")
    private String componentName;

    private boolean isActive;
}
