package com.sagar.attlasian;

// Interface for rate limiting strategies
public interface RateLimitStrategy {
    boolean allowRequest(String clientId);
}