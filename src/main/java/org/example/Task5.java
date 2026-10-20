package org.example;

import java.util.*;

public class Task5 {
    static final long MOD = 1_000_000_007L;

    static class BIT {
        int size;
        int[] len;
        long[] cnt;

        BIT(int size) {
            this.size = size;
            len = new int[size + 1];
            cnt = new long[size + 1];
            Arrays.fill(cnt, 0);
        }

        void update(int idx, int l, long c) {
            while (idx <= size) {
                if (l > len[idx]) {
                    len[idx] = l;
                    cnt[idx] = c % MOD;
                } else if (l == len[idx]) {
                    cnt[idx] = (cnt[idx] + c) % MOD;
                }
                idx += idx & (-idx);
            }
        }

        // возвращает {maxLen, sumCnt}
        long[] query(int idx) {
            int bestLen = 0;
            long bestCnt = 0;
            while (idx > 0) {
                if (len[idx] > bestLen) {
                    bestLen = len[idx];
                    bestCnt = cnt[idx];
                } else if (len[idx] == bestLen && bestLen > 0) {
                    bestCnt = (bestCnt + cnt[idx]) % MOD;
                }
                idx -= idx & (-idx);
            }
            return new long[]{bestLen, bestCnt};
        }
    }

    public static void solve(String[] input) {
        int n = Integer.parseInt(input[0].trim());
        String[] parts = input[1].trim().split("\\s+");
        long[] a = new long[n];
        long[] sorted = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(parts[i]);
            sorted[i] = a[i];
        }
        Arrays.sort(sorted);
        // сжатие с уникальными значениями
        int[] rank = new int[n];
        int uniq = 0;
        long[] uniqVals = new long[n];
        for (int i = 0; i < n; i++) {
            if (uniq == 0 || uniqVals[uniq - 1] != sorted[i]) {
                uniqVals[uniq++] = sorted[i];
            }
        }
        for (int i = 0; i < n; i++) {
            rank[i] = lowerBound(uniqVals, uniq, a[i]) + 1; // 1-based
        }

        BIT bit = new BIT(uniq);
        int[] myLen = new int[n];
        long[] myCnt = new long[n];
        int globalMax = 0;

        for (int i = 0; i < n; i++) {
            long[] q = bit.query(rank[i] - 1); // строго меньше
            int l = (int) q[0] + 1;
            long c = (q[0] == 0) ? 1 : q[1];
            myLen[i] = l;
            myCnt[i] = c % MOD;
            bit.update(rank[i], l, c);
            if (l > globalMax) globalMax = l;
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            if (myLen[i] == globalMax) total = (total + myCnt[i]) % MOD;
        }

        System.out.println(globalMax + " " + total);
    }

    static int lowerBound(long[] arr, int n, long x) {
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < x) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}