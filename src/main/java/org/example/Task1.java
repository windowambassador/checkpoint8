package org.example;

public class Task1 {
    public static void solve(String[] input) {
        int n = Integer.parseInt(input[0].trim());
        String[] parts = input[1].trim().split("\\s+");
        long[] h = new long[n];
        for (int i = 0; i < n; i++) h[i] = Long.parseLong(parts[i]);

        if (n == 1) { System.out.println(0); return; }

        long[] dp = new long[n];
        dp[0] = 0;
        dp[1] = Math.abs(h[1] - h[0]);
        for (int i = 2; i < n; i++) {
            long a = dp[i - 1] + Math.abs(h[i] - h[i - 1]);
            long b = dp[i - 2] + Math.abs(h[i] - h[i - 2]);
            dp[i] = Math.min(a, b);
        }
        System.out.println(dp[n - 1]);
    }
}