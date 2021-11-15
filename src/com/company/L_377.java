package com.company;

public class L_377 {

    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target+1];
        dp[0] = 0;
        for (int i = 1; i <= target; i++){
            for (int j:nums){
                if (i >= j)
                dp[i] = dp[i-j]+1;

            }
        }
        return dp[target];

    }

    public static void main(String[] args) {

    }
}
