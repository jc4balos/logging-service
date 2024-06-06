package com.jc4balos.logging_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "component")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "component_id")
    private Long componentId;

    @Column(nullable = false, unique = true, length = 100, name = "component_name")
    private String componentName;

    @Column(nullable = false)
    private boolean isActive;

}
