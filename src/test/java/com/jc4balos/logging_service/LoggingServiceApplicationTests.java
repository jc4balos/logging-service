package com.jc4balos.logging_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jc4balos.logging_service.controller.v1.ComponentController;

import lombok.RequiredArgsConstructor;

@SpringBootTest
@RequiredArgsConstructor
class LoggingServiceApplicationTests {

	private final ComponentController componentController;

	@Test
	void contextLoads() {
	}

}
