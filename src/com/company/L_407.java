package com.company;

public class L_407 {

    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        if ( n < 3 || m < 3)return 0;
        int[][] lHeight = new int[n][m];
        int[][] rHeight = new int[n][m];
        for (int i = 1; i < n-1; i++){
            for (int j = 0; j < m; j++){
                lHeight[i][j] = Math.max(lHeight[i][j],heightMap[i][j]);
                rHeight[i][m-j-1] = Math.max( rHeight[i][m-j-1],heightMap[i][m-j-1]);
            }
        }
        return 0;
    }
}
