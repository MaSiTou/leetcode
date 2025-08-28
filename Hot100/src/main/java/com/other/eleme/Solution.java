package com.other.eleme;

import java.util.*;

public class Solution {
    public void test(){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        in.nextLine();
        String[] s = {"#???#","#?#?#","##?##","###?#","#?###"};
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(0,1,1,1,0));
        list.add(Arrays.asList(2,2,2,2,2));
        list.add(Arrays.asList(0,3,0,4,0));
        list.add(Arrays.asList(0,3,0,3,0));
        list.add(Arrays.asList(1,1,0,3,3));
        list.add(Arrays.asList(0,4,0,3,0));
        list.add(Arrays.asList(0,4,0,1,0));
        list.add(Arrays.asList(0,3,3,3,3));
        list.add(Arrays.asList(0,1,0,1,0));
        list.add(Arrays.asList(0,1,0,3,0));
        Map<List<?>,Integer> map = new HashMap<>();
        map.put(Arrays.asList(0,1,1,1,0),0);
        map.put(list.get(1),1);
        map.put(list.get(2),2);
        map.put(list.get(3),3);
        map.put(list.get(4),4);
        map.put(list.get(5),5);
        map.put(list.get(6),6);
        map.put(list.get(7),7);
        map.put(list.get(8),8);
        map.put(list.get(9),9);
        int cheng = 1;
        for (int i=1;i<number;i++){
            cheng *= 10;
        }
        int result = 0;
        for (int i=0;i<number;i++){
            List<Integer> flag = new ArrayList<>();
            for (int j=0;j<5;j++){
                String temp = in.nextLine();
                System.out.println("更改前："+temp);
                char[] c = temp.toCharArray();
                for (int k=0;k<c.length;k++){
                    if (Character.isDigit(c[k])){
                        c[k] = '?';
                    }
                }
                temp = new String(c);
                System.out.println("更改后"+temp);
                for (int k=0;k<s.length;k++){
                    if (s[k].equals(temp)){
                        flag.add(k);
                        break;
                    }
                }
            }
            result +=map.get(flag)*cheng;
            cheng /= 10;
        }
        System.out.println(result);
    }
}
