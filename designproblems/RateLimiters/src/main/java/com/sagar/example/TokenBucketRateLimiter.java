package com.sagar.example;

import java.util.concurrent.locks.ReentrantLock;

public class TokenBucketRateLimiter {

    private final long capacity;               // Max tokens
    private final double refillRatePerSecond;  // Tokens added per second
    private double tokens;                     // Current token count
    private long lastRefillTimestamp;          // Last refill time (ns)

    // Explicit lock instead of synchronized
    private final ReentrantLock lock = new ReentrantLock();

    public TokenBucketRateLimiter(long capacity, double refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.tokens = capacity;
        this.lastRefillTimestamp = System.nanoTime();
    }

    public boolean allowRequest() {
        lock.lock();  // acquire the lock manually
        try {
            refill();

            if (tokens >= 1) {
                tokens -= 1;  // consume one token
                return true;
            }

            return false;
        } finally {
            lock.unlock();  // always release the lock (important!)
        }
    }

    private void refill() {
        long now = System.nanoTime();
        double elapsedSeconds = (now - lastRefillTimestamp) / 1_000_000_000.0;

        double tokensToAdd = elapsedSeconds * refillRatePerSecond;
        tokens = Math.min(capacity, tokens + tokensToAdd);

        lastRefillTimestamp = now;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(5, 1);

        for (int i = 1; i <= 10; i++) {
            boolean allowed = limiter.allowRequest();
            System.out.println("Request " + i + " → " + (allowed ? "✅ Allowed" : "❌ Blocked"));
            Thread.sleep(300);
        }
    }
}
