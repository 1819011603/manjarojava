package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class L_5895 {
    public int minOperations(int[][] grid, int x) {
        int t = grid[0][0] % x;
        int[] temp = new int[grid.length * grid[0].length];
        int s = 0;
        for (int[] i: grid){
            for (int j:i){
                temp[s++] = j;
                int k = j % x;
                if (k != t){
                    return -1;
                }
            }
        }
        Arrays.sort(temp);
        int j = temp[temp.length/2];
        int ans = 0;
        for (int i = 0; i < temp.length; i++){
            ans+= Math.abs(temp[i]-j)/x;
        }
        return ans;
    }
}
