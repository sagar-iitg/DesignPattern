package com.sagar.attlasian.impl;

import com.sagar.attlasian.RateLimitStrategy;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

// Sliding Window Log Strategy
public class SlidingWindowLog implements RateLimitStrategy {
    private final int limit;
    private final int windowSizeInSeconds;
    private final ConcurrentHashMap<String, ConcurrentHashMap<Long, AtomicInteger>> clientData = new ConcurrentHashMap<>();

    public SlidingWindowLog(int limit, int windowSizeInSeconds) {
        this.limit = limit;
        this.windowSizeInSeconds = windowSizeInSeconds;
    }

    @Override
    public boolean allowRequest(String clientId) {
        long currentTime = System.currentTimeMillis() / 1000;
        ConcurrentHashMap<Long, AtomicInteger> windowCounts = clientData.computeIfAbsent(clientId, k -> new ConcurrentHashMap<>());

        // Remove old entries
        windowCounts.entrySet().removeIf(entry -> entry.getKey() < currentTime - windowSizeInSeconds);

        // Increment the counter for the current second
        windowCounts.computeIfAbsent(currentTime, k -> new AtomicInteger()).incrementAndGet();

        // Calculate total requests in the window
        int totalRequests = windowCounts.values().stream().mapToInt(AtomicInteger::get).sum();

        return totalRequests <= limit;
    }
}