package com.sagar.attlasian;

// RateLimiter class that uses a strategy
class RateLimiter {
    private final RateLimitStrategy strategy;

    public RateLimiter(RateLimitStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean allowRequest(String clientId) {
        return strategy.allowRequest(clientId);
    }
}
