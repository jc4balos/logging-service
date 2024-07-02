package com.jc4balos.logging_service.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "logs", indexes = {
        @Index(name = "logs_service_component_idx", columnList = "logs_component_id"),
        @Index(name = "logs_username_idx", columnList = "username")
})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "log_id")
    private Long logId;

    @ManyToOne(targetEntity = ServiceComponent.class)
    @JoinColumn(nullable = false, name = "logs_component_id")
    private ServiceComponent serviceComponent;

    @Column(nullable = false, name = "username")
    private String userName;

    @Column(nullable = false, length = 1000, name = "event")
    private String event;

    @CreationTimestamp
    @Column(nullable = false, name = "time_stamp")
    private LocalDateTime timeStamp;

}