package com.Test.test;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long k = sc.nextLong();

            long ceilKHalf = (k + 1) / 2;
            long rMax = ceilKHalf - 1;

            long minY = Long.MAX_VALUE;

            // 直接计算可能的 t 值
            if (rMax > 0) {
                long t = Math.min(n, m / rMax);
                while (t >= 0) {
                    long used = t * rMax;
                    if (used <= m) {
                        long mRemaining = m - used;
                        long sAvailable = n - t;
                        if (sAvailable >= 0) {
                            if (mRemaining == 0) {
                                long sumA = (m - t * rMax) / k;
                                if (sumA >= 0 && sAvailable >= 0) {
                                    minY = Math.min(minY, sumA);
                                }
                            } else {
                                if (sAvailable > 0) {
                                    long q = mRemaining / k;
                                    long rem = mRemaining % k;
                                    long y = q;
                                    if (rem >= ceilKHalf) {
                                        y++;
                                    }
                                    long sumA = (m - mRemaining - t * rMax) / k;
                                    long totalY = sumA + y;
                                    if (sumA >= 0 && totalY >= 0) {
                                        minY = Math.min(minY, totalY);
                                    }
                                }
                            }
                        }
                    }
                    t--;
                }
            } else {
                long q = m / k;
                long rem = m % k;
                long y = q;
                if (rem >= ceilKHalf) {
                    y++;
                }
                if (y >= 0 && n >= 0) {
                    minY = Math.min(minY, y);
                }
            }

            System.out.println(minY == Long.MAX_VALUE ? -1 : minY);
        }
        sc.close();
    }
}    