package com.sagar;

public class TokenBucketRateLimiter {

    private final long capacity;             // Max tokens that can be stored
    private final double refillRatePerSecond; // Tokens added per second
    private double tokens;                   // Current token count
    private long lastRefillTimestamp;        // Last refill time in nanoseconds

    public TokenBucketRateLimiter(long capacity, double refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.tokens = capacity;              // Start full
        this.lastRefillTimestamp = System.nanoTime();
    }

    // synchronized -> thread-safe
    public synchronized boolean allowRequest() {
        refill();

        if (tokens >= 1) {
            tokens -= 1;                     // consume one token
            return true;                     // allow request
        }

        return false;                        // reject request
    }

    private void refill() {
        long now = System.nanoTime();
        double elapsedSeconds = (now - lastRefillTimestamp) / 1_000_000_000.0;

        // tokens to add = elapsed * refillRate
        double tokensToAdd = elapsedSeconds * refillRatePerSecond;
        tokens = Math.min(capacity, tokens + tokensToAdd);

        lastRefillTimestamp = now;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(5, 1); // 5 tokens max, +1 token/sec

        for (int i = 1; i <= 10; i++) {
            boolean allowed = limiter.allowRequest();
            System.out.println("Request " + i + " → " + (allowed ? "✅ Allowed" : "❌ Blocked"));
            Thread.sleep(300); // simulate request every 300ms
        }
    }
}
