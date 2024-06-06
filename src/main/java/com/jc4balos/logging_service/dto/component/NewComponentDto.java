package com.jc4balos.logging_service.dto.component;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class NewComponentDto {

    @NotEmpty(message = "Component Name is required.")
    public String componentName;

}
