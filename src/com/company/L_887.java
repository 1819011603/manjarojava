package com.company;

public class L_887 {

    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];

        return dfs1(dp,k,n);
    }


    // 超时
    public int dfs(int[][] dp,int k, int n){
        if (dp[k][n] > 0)return dp[k][n];
        if (k == 1 || n == 0){
            return dp[k][n] = n;
        }
        int max = Integer.MAX_VALUE;

        // 超时的原因就是需要O（n）的时间复杂度去找最坏情况的最小值
        for (int i = 1; i <=n; i++){
            max = Math.min(max,Math.max(dp[k-1][n-1] = dfs(dp,k-1,n-i),dp[k][i-1] = dfs(dp,k,i-1))+1);
        }
        return max;
    }
    public int dfs1(int[][] dp,int k, int n){
        if (dp[k][n] > 0 || n == 0)return dp[k][n];
        if (k == 1 ){
            return dp[k][n] = n;
        }

        int lo = 1,hi = n,a,b;
        while (lo+1 < hi){
            int mid = (lo+hi)>>1;
            a = dfs1(dp,k-1,mid-1);
            b = dfs1(dp,k,n-mid);
            if (a > b){
                hi = mid;
            }else if (a < b ){
                lo = mid;
            }else lo = hi = mid;
        }
        return  dp[k][n] = 1 + Math.min(Math.max(dfs1(dp,k-1,lo-1), dfs1(dp,k,n-lo)),Math.max(dfs1(dp,k-1,hi-1),dfs1(dp,k,n-hi)));

    }


    public static void main(String[] args) {
        System.out.println(new L_887().superEggDrop(2,10240));
        System.out.println(new L_887().superEggDrop(4,10000));
    }
}
