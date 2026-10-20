package org.example;

public class Task2 {
    public static void solve(String[] input) {
        String[] first = input[0].trim().split("\\s+");
        int n = Integer.parseInt(first[0]);
        int W = Integer.parseInt(first[1]);

        int[] w = new int[n];
        long[] v = new long[n];
        for (int i = 0; i < n; i++) {
            String[] p = input[1 + i].trim().split("\\s+");
            w[i] = Integer.parseInt(p[0]);
            v[i] = Long.parseLong(p[1]);
        }

        long[] dp = new long[W + 1]; // dp[j] = макс. полезность при массе <= j
        for (int i = 0; i < n; i++) {
            for (int j = W; j >= w[i]; j--) {
                long cand = dp[j - w[i]] + v[i];
                if (cand > dp[j]) dp[j] = cand;
            }
        }
        System.out.println(dp[W]);
    }
}