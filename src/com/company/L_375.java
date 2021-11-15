package com.company;

public class L_375 {
    int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n+10][n+10];

        return dfs(1,n);
    }

    public int dfs(int l, int r){
        if(r- l <= 0)return 0;

        if(dp[l][r] != 0)return dp[l][r];
        int min = Integer.MAX_VALUE;

        for(int i = (r+l)/2; i <= r; i++){
            int ll = dfs(l,i-1);
            int rr = dfs(i+1,r);
            min = Math.min(min,Math.max(ll,rr)+i);
        }


        return dp[l][r] = min;
    }
    public static void main(String[] args) {
        System.out.println(new L_375().getMoneyAmount(40));
    }
}
