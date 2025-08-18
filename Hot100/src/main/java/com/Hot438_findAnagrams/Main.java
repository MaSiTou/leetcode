package com.Hot438_findAnagrams;


import java.util.*;

public class Main {
    private static char[] p_char;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        p_char = p.toCharArray();
        Arrays.sort(p_char);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0;i<=s.length()-p.length();i++){
            if (judge(s.substring(i,i+p.length()))){
                result.add(i);
            }
        }
        System.out.println(result);
    }
    public static boolean judge(String s_sub){
        char[] s_char = s_sub.toCharArray();
        Arrays.sort(s_char);
        for(int i=0;i<p_char.length;i++){
            if (p_char[i] != s_char[i]){
                return false;
            }
        }
        return true;
    }
}
