package com.Test.test;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 输入字符串长度
        int g = scanner.nextInt(); // 输入g值
        scanner.nextLine(); // 消耗掉换行符
        String s = scanner.nextLine(); // 输入字符串
        scanner.close();

        int[] oddCount = new int[26]; // 用于统计奇数位置字符的出现次数
        int[] evenCount = new int[26]; // 用于统计偶数位置字符的出现次数
        long count = 0; // 用于统计满足条件的字符对数量

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i); // 获取当前字符
            int index = c - 'a'; // 将字符转换为索引值（a=0, b=1, ..., z=25）

            if (i % 2 == 0) { // 如果当前是偶数位置
                int left = Math.max(0, index - g); // 计算左边界
                int right = Math.min(25, index + g); // 计算右边界
                for (int j = left; j <= right; j++) { // 遍历范围内的字符
                    count += evenCount[j]; // 累加偶数位置的计数
                }
                evenCount[index]++; // 当前字符在偶数位置的计数加1
            } else { // 如果当前是奇数位置
                int left = Math.max(0, index - g); // 计算左边界
                int right = Math.min(25, index + g); // 计算右边界
                for (int j = left; j <= right; j++) { // 遍历范围内的字符
                    count += oddCount[j]; // 累加奇数位置的计数
                }
                oddCount[index]++; // 当前字符在奇数位置的计数加1
            }
        }

        // 处理同一奇偶性位置内的字符对
        for (int i = 0; i < 26; i++) {
            if (evenCount[i] > 1) {
                count += (long) evenCount[i] * (evenCount[i] - 1) / 2;
            }
            if (oddCount[i] > 1) {
                count += (long) oddCount[i] * (oddCount[i] - 1) / 2;
            }
        }

        System.out.println(count); // 输出最终结果
    }
}