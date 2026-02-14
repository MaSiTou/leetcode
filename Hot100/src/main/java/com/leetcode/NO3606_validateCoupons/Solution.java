package com.leetcode.NO3606_validateCoupons;

import java.util.*;

class coup{
    String code;
    String businessLine;
    String isActive;
    coup(String code, String businessLine, boolean isActive){
        this.code = code;
        this.businessLine = businessLine;
        this.isActive = isActive+"";
    }

    public String code() {
        return code;
    }
}
class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = isActive.length;
        Set<String> validBusinessLine = new HashSet<>(){{
            add("electronics");
            add("grocery");
            add("pharmacy");
            add("restaurant");
        }
        };
        List<coup> coups = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isActive[i] && validBusinessLine.contains(businessLine[i])){
                String nowCode = code[i];
                boolean canAddResult = true;
                for(Character c:nowCode.toCharArray()){
                    if (!Judge(c)){
                        canAddResult = false;
                        break;
                    }
                }
                if(canAddResult && !nowCode.isEmpty()){
                    coups.add(new coup(code[i],businessLine[i],isActive[i]));
                }
            }
        }

        Collections.sort(coups,new Comparator<coup>(){
            @Override
            public int compare(coup o1, coup o2) {
                int result = o1.businessLine.compareTo(o2.businessLine);
                return result!= 0 ? result: o1.code.compareTo(o2.code);
            }
        });
        return coups.stream().map(coup::code).toList();
    }
    public boolean Judge(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == '_');
    }
}