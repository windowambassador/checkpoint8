package org.example;

public class Task3 {
    public static void solve(String[] input) {
        String s = input[0].trim();
        String t = input[1].trim();
        int n = s.length(), m = t.length();

        // dp в двух строках для экономии памяти (n*m <= 9e6 и так ок, но сделаем компактно)
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char cs = s.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                if (cs == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}