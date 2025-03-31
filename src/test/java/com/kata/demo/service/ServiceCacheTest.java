package com.kata.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceCacheTest {

    private ServiceCache serviceCache;

    @BeforeEach
    void instantiateService() {
    	serviceCache = new ServiceCache();
    }

    @Test
    void testPutAndGetCache() {
        // Add data to cache
    	serviceCache.addData("Firstkey", "FirstValue", 15);

        // check data
        String cachedValue = serviceCache.get("Firstkey");
        assertEquals("FirstValue", cachedValue);
    }

    @Test
    void testCacheExpiration() throws InterruptedException {
        // add data cache with TTL 2 seconds
    	serviceCache.addData("SecondKey", "secondValue", 2);

        // Waiting data expiration
        Thread.sleep(3300);

        // Check data 
        String cachedValue = serviceCache.get("SecondKey");
        assertNull(cachedValue);
    }


}


