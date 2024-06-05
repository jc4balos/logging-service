package com.jc4balos.logging_service.dto.component;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;

public class NewComponentDto {

    @NotNull(message = "Component Name is required.")
    public String componentName;

    public NewComponentDto() {
    }

    public NewComponentDto(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentName() {
        return this.componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public NewComponentDto componentName(String componentName) {
        setComponentName(componentName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NewComponentDto)) {
            return false;
        }
        NewComponentDto newComponentDto = (NewComponentDto) o;
        return Objects.equals(componentName, newComponentDto.componentName);
    }

    @Override
    public String toString() {
        return "{" +
                " componentName='" + getComponentName() + "'" +
                "}";
    }
}
