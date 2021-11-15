package com.company;

public class L_718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        dp[0][0] = 0;
        int ans = 0;
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                if (nums1[i] == nums2[j]){
                    dp[i+1][j+1] =dp[i][j]+1;
                    ans = Math.max(ans,dp[i+1][j+1]);
                }
            }
        }
        return ans;
    }
}
