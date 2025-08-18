package com.Test.test;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] ais = new int[n];
        List<Integer> list = new ArrayList<>();
        int number = 0;
        for (int i = 0; i < n; i++) {
            ais[i] = scanner.nextInt();
            list.add(ais[i]);
            number ++;
        }
        Collections.reverse(list);
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = list.get(i);
        }
        int start = 0;
        int end = n - 1;
        for (int i = 0; i < q; i++){
            char c = scanner.next().charAt(0);
            int x = scanner.nextInt();
            Set<Integer> set = new HashSet<>();
            System.out.println("x" + x);
            if (c == 'L'){
                for (int j=0;j<x;j++){
                    set.add(ais[(start + j) %n]);
                }
                start = (start + x) % n;
            }
            else{
                for (int j=0;j<x;j++){
                    set.add(ais[(end - j+n) %n]);
                }
                end = (end - x+n) % n;
            }
            System.out.println(set.size());
        }

    }
}
