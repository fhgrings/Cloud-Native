package com.github.ilegra.final_project.app_service.eureka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Discovery {
	
	private final RestTemplate REST_TEMPLATE;
	private final String URL = "http://localhost:8080/eureka/v2/apps/";
	private final String IP_KEY = "\"ipAddr\":\"";
	private final String PORT_KEY = "\"port\":";
	
	public Discovery() {
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
	
	public List<String> getIPsAndPorts(String appID) {
		List<String> ipsAndPorts = new ArrayList<>();
		HttpEntity<String> entity = new HttpEntity<>(jsonHeaders());
	    ResponseEntity<String> response =
	    		REST_TEMPLATE.exchange(URL + appID, HttpMethod.GET, entity, String.class);
		String body = response.getBody();
		while(body.contains(IP_KEY) && body.contains(PORT_KEY)) {
			ipsAndPorts.add(getFirstIP(body) + ":" + getFirstPort(body));
			body = body.substring(body.indexOf(PORT_KEY) + PORT_KEY.length());
		}
		return ipsAndPorts;
	}
	
	private String getFirstIP(String body) {
		String splittedResponse = body.split("\"ipAddr\":\"")[1];
		return splittedResponse.substring(0, splittedResponse.indexOf("\""));
	}
	
	private String getFirstPort(String body) {
		String splittedResponse = body.split("\"port\":")[1];
		return splittedResponse.substring("{\"$\":".length(), splittedResponse.indexOf(","));
	}
	
}
