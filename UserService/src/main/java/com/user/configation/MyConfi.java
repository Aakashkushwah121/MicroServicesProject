package com.user.configation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfi {

	@Bean
	public RestTemplate resttemplate()
	{
		return new RestTemplate();
	}
}
