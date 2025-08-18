package com.Test.test;

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] s1 = new int[n];
            int[] s2 = new int[m];
            for (int i = 0; i < n; i++) {
                s1[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                s2[i] = scanner.nextInt();
            }
            int result = getMaxValue(s1, s2);
            System.out.println(result);
        }
        scanner.close();
    }

    public static int getMaxValue(int[] s1, int[] s2) {
        int[] count1 = new int[10];
        int[] count2 = new int[10];
        for (int num : s1) {
            System.out.println(num);
            count1[num]++;
        }
        for (int num : s2) {
            count2[num]++;
        }
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count1[i]; j++) {
                list1.add(i);
            }
        }
        Collections.sort(list1, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        boolean lessThan = false;
        for (int i = 0; i < list1.size(); i++) {
            int digit = list1.get(i);
            boolean canUse = true;
            for (int j = 0; j < sb.length(); j++) {
                int curDigit = sb.charAt(j) - '0';
                if (digit > curDigit) {
                    if (!lessThan) {
                        canUse = false;
                        break;
                    }
                } else if (digit < curDigit) {
                    lessThan = true;
                }
            }
            if (canUse) {
                boolean valid = true;
                for (int j = 0; j < 10; j++) {
                    int tempCount1 = count1[j];
                    int tempCount2 = count2[j];
                    if (j == digit) {
                        tempCount1--;
                    }
                    if (tempCount1 > tempCount2) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    sb.append(digit);
                    count1[digit]--;
                } else {
                    canUse = false;
                }
            }
            if (!canUse) {
                int remainingDigit = -1;
                for (int j = digit + 1; j < 10; j++) {
                    if (count1[j] > 0) {
                        remainingDigit = j;
                        break;
                    }
                }
                if (remainingDigit != -1) {
                    for (int j = i; j < list1.size(); j++) {
                        if (list1.get(j) == remainingDigit) {
                            Collections.swap(list1, i, j);
                            break;
                        }
                    }
                    sb.append(remainingDigit);
                    count1[remainingDigit]--;
                    lessThan = true;
                } else {
                    return -1;
                }
            }
        }
        if (sb.length() == 0) {
            return -1;
        }
        return Integer.parseInt(sb.toString());
    }
}
