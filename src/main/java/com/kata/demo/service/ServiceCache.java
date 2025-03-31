package com.kata.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.kata.demo.model.CacheData;

public class ServiceCache {
	  private Map<String, CacheData> cache = new HashMap<>();

	    public void addData(String key, String value, long ttl) {
	        cache.put(key, new CacheData(value, ttl));
	    }

	    public String get(String key) {
	    	CacheData existsCache = cache.get(key);

	        if (existsCache == null || existsCache.isExpired()) {
	            cache.remove(key); 
	            return null;
	        }
	        return existsCache.getValue();
	    }

	    public void clear() {
	        cache.clear();
	    }
}



