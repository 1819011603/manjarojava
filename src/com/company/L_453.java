package com.company;

import java.util.Arrays;

public class L_453 {
    public int minMoves(int[] nums) {
        int max = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.min(max,nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] -= max;
        }
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {

    }
}
