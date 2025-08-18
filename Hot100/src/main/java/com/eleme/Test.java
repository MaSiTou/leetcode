package com.eleme;

import java.util.Scanner;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取炮的数量

        // 使用 Map 存储每一行、每一列的炮位置
        HashMap<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> colMap = new HashMap<>();

        // 存储所有炮的坐标
        int[][] cannons = new int[n][2];

        // 读取输入数据
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            cannons[i][0] = x;
            cannons[i][1] = y;

            // 如果 x 不在 rowMap 中，则手动添加
            if (!rowMap.containsKey(x)) {
                rowMap.put(x, new TreeSet<>());
            }
            rowMap.get(x).add(y); // 在 x 这一行插入 y 坐标

            // 如果 y 不在 colMap 中，则手动添加
            if (!colMap.containsKey(y)) {
                colMap.put(y, new TreeSet<>());
            }
            colMap.get(y).add(x); // 在 y 这一列插入 x 坐标
        }

        // 计算每个炮的攻击数量
        for (int i = 0; i < n; i++) {
            int x = cannons[i][0];
            int y = cannons[i][1];
            int attackCount = 0;

            // 查找同列的最近炮架
            TreeSet<Integer> colSet = colMap.get(y);
            Integer up = colSet.higher(x);   // 找到比 x 大的最小值
            Integer down = colSet.lower(x);  // 找到比 x 小的最大值

            // 查找同行的最近炮架
            TreeSet<Integer> rowSet = rowMap.get(x);
            Integer right = rowSet.higher(y); // 找到比 y 大的最小值
            Integer left = rowSet.lower(y);   // 找到比 y 小的最大值

            // 统计攻击的数量
            if (up != null) attackCount++;
            if (down != null) attackCount++;
            if (right != null) attackCount++;
            if (left != null) attackCount++;

            // 输出结果
            System.out.println(attackCount);
        }

        scanner.close();
    }
}
