package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_132 {
    boolean[][] dp;

    public int minCut(String s) {
        dp= new boolean[s.length()][s.length()];
        int[] t = new int[s.length()+1];
        t[0] = 0;
        for (int l = 1; l <= s.length(); l++){
            int m = s.length() -l;
            for (int j =0; j <= m; j++){
                if (l == 1){
                    dp[j][j] = true;

                    t[l+j] = t[j]+1;
                }else if (l == 2 ){
                    if (s.charAt(j) == s.charAt(j+1)){
                        dp[j][j+1]  =true;
                        t[l+j] = Math.min(t[j]+1,t[l+j]);
                    }

                }else {

                    if (s.charAt(j) == s.charAt(j+l-1) && dp[j+1][j+l-2]){
                        dp[j][j+l-1] = true;
                        t[l+j] = Math.min(t[j]+1,t[l+j]);
                    }
                }
            }
        }


        return t[s.length()]-1;
    }

    public static void main(String[] args) {
        System.out.println(new L_132().minCut("ababa"));
    }
}
