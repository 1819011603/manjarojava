package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class L_1278 {
    public static int cost(char[] s,int l,int r){
        int ans = 0;
        while(l < r){
            if(s[l++] != s[r--])ans++;

        }
        return ans;
    }
    public static int palindromePartition(String s, int k) {
        int len = s.length();
        int[][] dp = new int[len+1][k+1];
        for(int i = 1; i <= len; i++){
            Arrays.fill(dp[i],len);
            dp[i][0] = 0;
        }
        char[] chars = s.toCharArray();


        for(int m = 1; m <= k; m++){
            for(int i = 1; i <= len; i++){
                if(m == 1){
                    dp[i][m] = cost(chars,0,i-1);
                }else {
                    for(int j = m; j <= i; j++){
                        dp[i][m] = Math.min(dp[i][m],dp[j-1][m-1] + cost(chars,j-1,i-1));
                    }
                }

            }
        }
        return dp[len][k];
    }

    public static void main(String[] args) {
        System.out.println(palindromePartition("abc",2));
        System.out.println(palindromePartition("aabbc",3));
        System.out.println(palindromePartition("abc",3));
        System.out.println(palindromePartition("abcaaa",3));

    }
}
