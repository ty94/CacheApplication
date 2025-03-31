package com.kata.demo.model;

import java.time.Instant;

public class CacheData {


	    private String value;
	    private Instant timestamp;
	    private long ttl;  

	    public CacheData(String value, long ttl) {
	        this.value = value;
	        this.timestamp = Instant.now();
	        this.ttl = ttl;
	    }

	    public String getValue() {
	        return value;
	    }

	    public Instant getTimestamp() {
	        return timestamp;
	    }

	    public long getTtl() {
	        return ttl;
	    }

	    public boolean isExpired() {
	        return Instant.now().isAfter(timestamp.plusSeconds(ttl));
	    }
	}



