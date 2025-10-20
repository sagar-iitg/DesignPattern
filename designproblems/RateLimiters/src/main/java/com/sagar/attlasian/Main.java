package com.sagar.attlasian;

import com.sagar.attlasian.impl.FixedWindowCounter;
import com.sagar.attlasian.impl.SlidingWindowLog;
import com.sagar.attlasian.impl.TokenBucket;

// Example usage
public class Main {
    public static void main(String[] args) {
        // Fixed Window Counter: 5 requests per 10 seconds
        RateLimiter fixedWindowLimiter = new RateLimiter(new FixedWindowCounter(5, 10));

        // Sliding Window Log: 5 requests per 10 seconds
        RateLimiter slidingWindowLimiter = new RateLimiter(new SlidingWindowLog(5, 10));

        // Token Bucket: 5 tokens capacity, refill rate of 0.5 tokens per second
        RateLimiter tokenBucketLimiter = new RateLimiter(new TokenBucket(5, 0.5));

        // Example usage
        String clientId = "user123";
        for (int i = 0; i < 10; i++) {
            System.out.println("Fixed Window: " + fixedWindowLimiter.allowRequest(clientId));
            System.out.println("Sliding Window: " + slidingWindowLimiter.allowRequest(clientId));
            System.out.println("Token Bucket: " + tokenBucketLimiter.allowRequest(clientId));
            System.out.println("---");

            try {
                Thread.sleep(1000); // Wait for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}