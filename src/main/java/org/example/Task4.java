package org.example;

import java.util.*;

public class Task4 {
    public static void solve(String[] input) {
        String[] first = input[0].trim().split("\\s+");
        int n = Integer.parseInt(first[0]);
        int C = Integer.parseInt(first[1]);

        int[] w = new int[n];
        long[] p = new long[n];
        for (int i = 0; i < n; i++) {
            String[] q = input[1 + i].trim().split("\\s+");
            w[i] = Integer.parseInt(q[0]);
            p[i] = Long.parseLong(q[1]);
        }

        final long NEG = Long.MIN_VALUE / 4;
        long[] dpProfit = new long[C + 1];
        long[] dpCount = new long[C + 1];
        boolean[] reachable = new boolean[C + 1];
        Arrays.fill(dpProfit, NEG);
        Arrays.fill(dpCount, Long.MAX_VALUE);
        dpProfit[0] = 0;
        dpCount[0] = 0;
        reachable[0] = true;

        for (int i = 0; i < n; i++) {
            for (int c = w[i]; c <= C; c++) {
                if (!reachable[c - w[i]]) continue;
                long np = dpProfit[c - w[i]] + p[i];
                long nc = dpCount[c - w[i]] + 1;
                if (!reachable[c]
                        || np > dpProfit[c]
                        || (np == dpProfit[c] && nc < dpCount[c])) {
                    reachable[c] = true;
                    dpProfit[c] = np;
                    dpCount[c] = nc;
                }
            }
        }

        if (!reachable[C]) {
            System.out.println(-1);
        } else {
            System.out.println(dpProfit[C] + " " + dpCount[C]);
        }
    }
}