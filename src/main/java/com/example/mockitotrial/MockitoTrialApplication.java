package com.example.mockitotrial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@SpringBootApplication
@EnableRetry
public class MockitoTrialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockitoTrialApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();

	}

	@Bean
	public HandlerInterceptorAdapter get(){
		return new LoginInterceptor();
	}

}
