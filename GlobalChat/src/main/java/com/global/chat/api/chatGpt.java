package com.global.chat.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class chatGpt {
	//@Value("${apikey}")
	private static String API_KEY = "";
	private static final String ENDPOINT = "https://api.openai.com/v1/completions";

	public static String generateText(String prompt, float temperature, int maxTokens) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.set("Authorization", "Bearer " + API_KEY);

	    Map<String, Object> requestBody = new HashMap<>();
	    requestBody.put("model","text-davinci-003");
	    requestBody.put("prompt", prompt);
	    requestBody.put("temperature", temperature);
	    requestBody.put("max_tokens", maxTokens);

	    HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<Map> response = restTemplate.postForEntity(ENDPOINT, requestEntity, Map.class);
	    return response.toString();
	}
}
