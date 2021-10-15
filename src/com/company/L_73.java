package com.company;

import java.util.Arrays;

public class L_73 {
    public int minDistance(String word1,String word2){
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 0;i <= n1; i++){
            for (int j = 0;j <= n2; j++){
                dp[i][j] = n1+n2;
                if (i == 0){
                    dp[0][j] = j;
                }else if(j == 0){
                    dp[i][0] = i;
                }else {
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    }
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        System.out.println(new L_73().minDistance("horse","ros"));
        System.out.println(new L_73().minDistance("intention","execution"));
    }

}
