package com.company;

import java.util.Arrays;

public class L_416 {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1)return false;
        sum>>=1;

        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int j :nums){
        for (int i = 1; i <= sum; i++){

                if (!dp[i] && i-j >= 0 && dp[i-j]){
                    dp[i] = true;
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {

    }
}
