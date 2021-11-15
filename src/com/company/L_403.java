package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L_403 {
    public static boolean canCross(int[] stones) {

        int n  = stones.length;
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }

        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;

        for (int i=1; i < stones.length; i++){

            for (int j = i-1; j >= 1; j--){
                int a = stones[i] - stones[j];
                if (a > j+1){
                    break;
                }
                dp[i][a] = dp[j][a - 1] || dp[j][a] || dp[j][a + 1];
                if (i == n-1 && dp[i][a]){
                    return true;
                }


            }


        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canCross(new int[]{0,1,3,5,6,8,12,17}));
    }

}
