package com.company;

public class L_123 {
    public int maxProfit(int[] prices) {
        // dp[0][i][0] 第一次买入最大值
        // dp[0][i][1] 第一次卖出最大值
        // dp[1][i][0] 前两次买入最大值  可以被看做为已经买卖了价格相同的两只股票
        // dp[1][i][1] 前两次卖出最大值
        int[][][] dp = new int[2][prices.length+1][2];

        dp[0][0][0] = -prices[0];
        dp[0][0][1] = 0;
        dp[1][0][0] = -prices[0];
        dp[1][0][1] = 0;

        for (int i = 1; i < prices.length; i++){
            int a = dp[0][i-1][0];
            int b = dp[0][i-1][1];
            int c = dp[1][i-1][0];
            int d = dp[1][i-1][1];
            dp[0][i][0] = Math.max(-prices[i],a);
            dp[0][i][1] = Math.max(a+prices[i],b );
            dp[1][i][0] = Math.max(b-prices[i],c);
            dp[1][i][1] = Math.max(c+prices[i],d);
        }
        return dp[1][prices.length-1][1];
    }

    public int maxProfit1(int[] prices) {
        // dp[0][i][0] 第一次买入最大值
        // dp[0][i][1] 第一次卖出最大值
        // dp[1][i][0] 前两次买入最大值  可以被看做为已经买卖了价格相同的两只股票
        // dp[1][i][1] 前两次卖出最大值


        int first_buy = -prices[0];
        int first_sail = 0;
        int second_buy = -prices[0];
        int second_sail = 0;

        for (int i = 1; i < prices.length; i++){
            second_sail = Math.max(second_sail,second_buy+prices[i]);
            second_buy = Math.max(second_buy,first_sail-prices[i]);
            first_sail = Math.max(first_sail,first_buy+prices[i]);
            first_buy = Math.max(first_buy,-prices[i]);
        }
        return second_sail;
    }

    public static void main(String[] args) {
        System.out.println(new L_123().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(new L_123().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new L_123().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new L_123().maxProfit(new int[]{1}));
    }
}
