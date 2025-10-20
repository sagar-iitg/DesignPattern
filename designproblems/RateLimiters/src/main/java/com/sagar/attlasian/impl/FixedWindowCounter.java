package com.sagar.attlasian.impl;

import com.sagar.attlasian.RateLimitStrategy;

import java.util.concurrent.ConcurrentHashMap;


// Fixed Window Counter Strategy
public class FixedWindowCounter implements RateLimitStrategy {
    private final int limit;
    private final int windowSizeInSeconds;
    private final ConcurrentHashMap<String, WindowData> clientData = new ConcurrentHashMap<>();

    public FixedWindowCounter(int limit, int windowSizeInSeconds) {
        this.limit = limit;
        this.windowSizeInSeconds = windowSizeInSeconds;
    }

    @Override
    public boolean allowRequest(String clientId) {
        long currentTime = System.currentTimeMillis() / 1000; //in second
        WindowData data = clientData.compute(clientId, (key, value) -> {
            if (value == null || currentTime - value.windowStart >= windowSizeInSeconds) {
                return new WindowData(currentTime, 1);
            }
            value.count++;
            return value;
        });
        return data.count <= limit;
    }

    private static class WindowData {
        long windowStart;
        int count;

        WindowData(long windowStart, int count) {
            this.windowStart = windowStart;
            this.count = count;
        }
    }
}
