package com.company;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class L_1559 {
    int m,n;
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(vis,grid,i,j,0,-1)){
                    return true;
                }
            }
        }
        return false;

    }
    int[][] dir = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
    public boolean dfs(boolean[][] vis,char[][] grid,int x, int y,int len,int direction){
        if(vis[x][y]){
            if(len >= 4){
                return true;
            }
            return false;
        }
        vis[x][y] = true;
        int next_x,next_y;
        for(int i = 0; i < 4; i++){
            next_x = x + dir[i][0];
            next_y = y + dir[i][1];
            if(next_x < 0 || next_x >= m || next_y < 0 || next_y >= n || grid[x][y] != grid[next_x][next_y] || (vis[next_x][next_y] && i + direction == 3))continue;
            if(dfs(vis,grid,next_x,next_y,len+1,i))return true;

        }return false;
    }

    public static void main(String[] args) {

    }
}
