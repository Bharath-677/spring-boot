package com.tejait.batch15.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.tejait.batch15.serviceimpl.AccountServiceImpl;

@Configuration
public class BeanConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder()
				//.baseUrl("http://localhost:8081")
				.build();	
	}
	
	//@Bean - it helps to creat method leval beans in configuration classes
	//public AccountServiceImpl accountservice() {
		
	//	return new AccountServiceImpl();
	//}
	
}
