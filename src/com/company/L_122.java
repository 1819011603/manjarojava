package com.company;

public class L_122 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);

    }
    public static void main(String[] args) {
        System.out.println(new L_122().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new L_122().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new L_122().maxProfit(new int[]{7,6,4,3,1}));
    }
}
