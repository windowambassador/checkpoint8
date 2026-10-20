package org.example;

public class Task6 {
    public static void solve(String[] input) {
        String s = input[0].trim();
        String t = input[1].trim();
        int n = s.length(), m = t.length();

        // dp[i][j] = длина SCS для s[i..] и t[j..]
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                if (i == n) { dp[i][j] = m - j; continue; }
                if (j == m) { dp[i][j] = n - i; continue; }
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < n && j < m) {
            char cs = s.charAt(i), ct = t.charAt(j);
            if (cs == ct) {
                sb.append(cs);
                i++; j++;
            } else {
                // идём туда, где dp меньше; при равенстве — меньший символ
                if (dp[i + 1][j] < dp[i][j + 1]) {
                    sb.append(cs); i++;
                } else if (dp[i + 1][j] > dp[i][j + 1]) {
                    sb.append(ct); j++;
                } else {
                    if (cs < ct) { sb.append(cs); i++; }
                    else { sb.append(ct); j++; }
                }
            }
        }
        while (i < n) { sb.append(s.charAt(i++)); }
        while (j < m) { sb.append(t.charAt(j++)); }

        System.out.println(sb);
    }
}