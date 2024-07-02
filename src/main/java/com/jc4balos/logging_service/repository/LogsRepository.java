package com.jc4balos.logging_service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jc4balos.logging_service.model.Logs;

public interface LogsRepository extends JpaRepository<Logs, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM logs WHERE logs_component_id=:componentId")
    Page<Logs> findByComponentId(@Param("componentId") Long componentId, Pageable pageable);

}
