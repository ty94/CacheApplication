package com.kata.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kata.demo.service.ServiceCache;

@RestController
@RequestMapping("/cache")
public class CacheController {
	
	  private final ServiceCache cacheService = new ServiceCache();

	    // Add data to cache
	    @PostMapping
	    public String AddCacheData(@RequestParam String key, @RequestParam String value, @RequestParam(defaultValue = "15") long ttl) {
	        cacheService.addData(key, value, ttl);
	        return "Data saved successfully!";
	    }

	    // Get data from cache
	    @GetMapping("/{key}")
	    public String getCacheData(@PathVariable String key) {
	        String value = cacheService.get(key);
	        if (value == null) {
	            return "Cache data expired or not found";
	        }
	        return value;
	    }

	    // Delete data cache
	    @DeleteMapping
	    public String clearCacheData() {
	        cacheService.clear();
	        return "Cache cleared !";
	    }

}




