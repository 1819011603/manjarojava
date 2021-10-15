package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class L_85 {

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        int[][] left = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j= 0; j < m; j++){
                if (matrix[i][j] == '0')continue;
                if (j == 0){
                    left[i][j] = matrix[i][j] - '0';
                }else {
                    left[i][j] = left[i][j-1] + 1;
                }
                ans = Math.max(left[i][j],ans);
                int k = i-1;
                int min = left[i][j];
                while (k >= 0 && min > 0){
                    min = Math.min(left[k][j],min);
                    ans = Math.max(ans,(i-k+1)*min);
                    k--;
                }
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        System.out.println(new L_85().maximalRectangle(new char[][]{
                {'1','0','1','1','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','1','1','0'},
        }));

        int[] ints = new int[]{2,3,2,5,1,4};
        Deque<Integer> minStack = new LinkedList<>();
        for (int i:ints){
            if (minStack.isEmpty()|| minStack.peek() >= i){
                minStack.push(i);
            }else{
                while (!minStack.isEmpty() && minStack.peek()<i)
                    minStack.pop();
                minStack.push(i);
            }
            System.out.println(minStack);
        }

    }


}
