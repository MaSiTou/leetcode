package com.Hot10_removeNthFromEnd;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Set<Integer> colorSet = new HashSet<>();
        for (int num : a) {
            colorSet.add(num);
        }
        int totalColors = colorSet.size();

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            if (x >= n) {
                System.out.println(totalColors);
            } else {
                System.out.println(calculateMaxColors(a, n, x));
            }
        }
    }

    private static int calculateMaxColors(int[] a, int n, int x) {
        Map<Integer, Integer> freq = new HashMap<>();
        int currentColors = 0;
        int maxColors = 0;

        // 初始化第一个窗口
        for (int i = 0; i < x; i++) {
            int color = a[i % n];
            freq.put(color, freq.getOrDefault(color, 0) + 1);
            if (freq.get(color) == 1) {
                currentColors++;
            }
        }
        maxColors = currentColors;

        // 滑动窗口
        for (int i = 1; i < n; i++) {
            // 移除左边元素
            int leftColor = a[(i - 1) % n];
            freq.put(leftColor, freq.get(leftColor) - 1);
            if (freq.get(leftColor) == 0) {
                currentColors--;
            }

            // 添加右边元素
            int rightPos = (i + x - 1) % n;
            int rightColor = a[rightPos];
            freq.put(rightColor, freq.getOrDefault(rightColor, 0) + 1);
            if (freq.get(rightColor) == 1) {
                currentColors++;
            }

            // 更新最大值
            if (currentColors > maxColors) {
                maxColors = currentColors;
            }
        }

        return maxColors;
    }
}