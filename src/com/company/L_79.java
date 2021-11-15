package com.company;

public class L_79 {
    int m,n;
    boolean ans = true;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m ; i++){
            for (int j = 0; j < n ; j++){
                if ( word.charAt(0) == board[i][j] && dfs(board,word,vis,i,j,1)){
                    return true;
                }
            }
        }
        return false;
    }
    private int[][] dire = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    public boolean dfs(char[][] board,String word,boolean[][] vis, int x, int y, int l){
        if (l == word.length()){
            ans = false;
            return true;
        }
        vis[x][y] = true;
        int next_x,next_y;
        for (int i = 0; i < 4 && ans; i++){
            next_x = x + dire[i][0];
            next_y = y + dire[i][1];
            if (next_x < 0 || next_x>=m || next_y < 0 || next_y >= n || vis[next_x][next_y] || word.charAt(l) != board[next_x][next_y])continue;

            if (ans && dfs(board,word,vis,next_x,next_y,l+1))return true;

        }
        vis[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(new L_79().exist(chars,"ABCCED"));
    }
}
