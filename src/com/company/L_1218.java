package com.company;

import java.util.HashMap;

public class L_1218 {
    public int longestSubsequence(int[] arr, int difference) {

        int[] map = new int[40010];
        int maxn = 1;
        for (int j : arr){
            int i1 = j + 20000;
            int i = map[i1 - difference];
            if (++i != 1){
                if (i > map[i1]){
                    map[i1] = i;
                }
                maxn = Math.max(maxn,i);

            }else map[i1] = 1;
        }
        return maxn;
    }

    public static void main(String[] args) {
        System.out.println(new L_1218().longestSubsequence(new int[]{1,2,3,4},1));
        System.out.println(new L_1218().longestSubsequence(new int[]{1,5,7,8,5,5,3,4,2,1},-2));
        System.out.println(new L_1218().longestSubsequence(new int[]{1,3,5,7},1));
    }

}
