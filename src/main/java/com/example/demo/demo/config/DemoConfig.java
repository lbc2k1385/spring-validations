package com.example.demo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.demo.service.DemoBean;
import com.example.demo.demo.service.DemoBeanImpl;

@Configuration
public class DemoConfig {
	
	@Bean
	public DemoBean demoBean() {
		return new DemoBeanImpl();
	}

}
