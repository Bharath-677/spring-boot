package com.tejait.batch15.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
@RequestMapping("webClient")
public class WebClientController {
	
	WebClient webClient;
	
	@GetMapping("asynchName")
	public String AsynchronousType() {
		String name="Teja IT";
		Mono<String> tagline=webClient.get()
				.uri("http://localhost:8081/test/tagline")
		.retrieve()
		.bodyToMono(String.class);  // Asynchronus - non-block
		//.uri(/test/tagline)
		
		return name.concat("  "+tagline.block());
		
	}
	@GetMapping("synchName")
	public String synchronousType() {
		String name="Teja IT";
		String tagline=webClient.get().uri("http://localhost:8081/test/tagline")
		.retrieve()
		.bodyToMono(String.class)
		.block();        // synchronus - blocking
		//.uri(/test/tagline)
		
		return name.concat("  "+tagline);
	
	}
}
