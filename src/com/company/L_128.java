package com.company;

import java.util.Arrays;

public class L_128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        Arrays.sort(nums);
        int ans = 1,time = 1;
        for(int i = 1; i < nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                time++;
                while (i < nums.length-1 && nums[i] == nums[i+1]){
                    i++;
                }
            }else{
                ans = Math.max(ans,time);
                time = 1;

            }
        }
        return Math.max(ans,time);
    }
    public static void main(String[] args) {

    }
}
