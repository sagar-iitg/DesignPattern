package com.sagar.attlasian.impl;

import com.sagar.attlasian.RateLimitStrategy;

import java.util.concurrent.ConcurrentHashMap;

// Token Bucket Strategy
public class TokenBucket implements RateLimitStrategy {
    private final int capacity;
    private final double refillRate;
    private final ConcurrentHashMap<String, TokenBucketState> clientData = new ConcurrentHashMap<>();

    public TokenBucket(int capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    @Override
    public boolean allowRequest(String clientId) {
        long currentTime = System.currentTimeMillis();
        TokenBucketState state = clientData.compute(clientId, (key, value) -> {
            if (value == null) {
                return new TokenBucketState(capacity, currentTime);
            }
            long timePassed = currentTime - value.lastRefillTimestamp;
            double tokensToAdd = timePassed * (refillRate / 1000.0);
            value.tokens = Math.min(capacity, value.tokens + tokensToAdd);
            value.lastRefillTimestamp = currentTime;
            return value;
        });

        if (state.tokens >= 1) {
            state.tokens--;
            return true;
        }
        return false;
    }

    private static class TokenBucketState {
        double tokens;
        long lastRefillTimestamp;

        TokenBucketState(double tokens, long lastRefillTimestamp) {
            this.tokens = tokens;
            this.lastRefillTimestamp = lastRefillTimestamp;
        }
    }
}