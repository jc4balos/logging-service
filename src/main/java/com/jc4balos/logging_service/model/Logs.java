package com.jc4balos.logging_service.model;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "log_id")
    private Long logId;

    @ManyToOne(targetEntity = Component.class)
    @JoinColumn(nullable = false, name = "logs_component_id")
    private Component component;

    @Column(nullable = false, name = "user_id")
    private Long userId;

    @Column(nullable = false, length = 1000, name = "event")
    private String event;

    @CreationTimestamp
    @Column(nullable = false, name = "time_stamp")
    private LocalDateTime timeStamp;

    public Logs() {
    }

    public Logs(Long logId, Component component, Long userId, String event, LocalDateTime timeStamp) {
        this.logId = logId;
        this.component = component;
        this.userId = userId;
        this.event = event;
        this.timeStamp = timeStamp;
    }

    public Long getLogId() {
        return this.logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Component getComponent() {
        return this.component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Logs logId(Long logId) {
        setLogId(logId);
        return this;
    }

    public Logs component(Component component) {
        setComponent(component);
        return this;
    }

    public Logs userId(Long userId) {
        setUserId(userId);
        return this;
    }

    public Logs event(String event) {
        setEvent(event);
        return this;
    }

    public Logs timeStamp(LocalDateTime timeStamp) {
        setTimeStamp(timeStamp);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Logs)) {
            return false;
        }
        Logs logs = (Logs) o;
        return Objects.equals(logId, logs.logId) && Objects.equals(component, logs.component)
                && Objects.equals(userId, logs.userId) && Objects.equals(event, logs.event)
                && Objects.equals(timeStamp, logs.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, component, userId, event, timeStamp);
    }

    @Override
    public String toString() {
        return "{" +
                " logId='" + getLogId() + "'" +
                ", component='" + getComponent() + "'" +
                ", userId='" + getUserId() + "'" +
                ", event='" + getEvent() + "'" +
                ", timeStamp='" + getTimeStamp() + "'" +
                "}";
    }

}