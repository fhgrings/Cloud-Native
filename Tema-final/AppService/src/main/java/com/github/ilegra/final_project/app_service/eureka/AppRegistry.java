package com.github.ilegra.final_project.app_service.eureka;

import java.util.Arrays;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AppRegistry {
	
	private final RestTemplate REST_TEMPLATE;
	private final String URL = "http://localhost:8080/eureka/v2/apps/";
	private final String APP_NAME = "app-service";
	
	public AppRegistry() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
				new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create().build());
		REST_TEMPLATE = new RestTemplate(clientHttpRequestFactory);
	}
	
	private HttpHeaders jsonHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    return headers;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void register() {
		REST_TEMPLATE.exchange(URL + APP_NAME, HttpMethod.POST,
				new HttpEntity<String>(RegistryBuilder.get(APP_NAME), jsonHeaders()), String.class);
	}
	
}
