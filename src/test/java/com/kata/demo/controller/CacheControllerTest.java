package com.kata.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CacheControllerTest {
	
	
	 @Autowired
	 private TestRestTemplate restTemplate;

	 private final String cacheUrl = "/cache";
	 
	 
    @Test
    void testAddAndGetCacheData() {
        // Add data cache
        String url = cacheUrl + "?key=user1&value=userName&ttl=7";
        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);

        // Check if response is OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Get data cache from API
        ResponseEntity<String> getResponse = restTemplate.getForEntity("/cache/user1", String.class);

        // Check cache value
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertEquals("userName", getResponse.getBody());
    }

}

