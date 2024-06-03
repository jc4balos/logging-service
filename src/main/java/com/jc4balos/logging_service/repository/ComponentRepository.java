package com.jc4balos.logging_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc4balos.logging_service.model.Component;

public interface ComponentRepository extends JpaRepository<Component, Long> {
}
