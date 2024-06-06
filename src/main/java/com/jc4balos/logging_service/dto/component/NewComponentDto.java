package com.jc4balos.logging_service.dto.component;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NewComponentDto {

    @NotNull(message = "Component Name is required.")
    public String componentName;

}
