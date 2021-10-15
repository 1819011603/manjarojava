package com.company;

import java.util.Arrays;

public class O_112 {
    int [][]dire = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
    int ans = 1;
    public int longestIncreasingPath(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                dfs(matrix,dp,i,j);
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix,int[][] dp,int i,int j){
        if (i <0 || i >= matrix.length || j < 0 || j >= matrix[0].length)return 0;
        if (dp[i][j] > 0)return dp[i][j];
        int nextI,nextJ;
        int max = 1;
        for (int k = 0; k < 4; k++){
            nextI = i + dire[k][0];
            nextJ = j + dire[k][1];
            if (nextI<0 || nextI>=matrix.length || nextJ < 0 || nextJ>=matrix[0].length || matrix[nextI][nextJ] >= matrix[i][j])continue;
            max = Math.max(dfs(matrix,dp,nextI,nextJ)+1,max);

        }
        ans = Math.max(ans,max);
        return dp[i][j] = max;
    }

    public static void main(String[] args) {
        System.out.println(new O_112().longestIncreasingPath(new int[][]{
                {3,4,5},
                {3,2,6},
                {2,2,1}
        }));
    }
}
