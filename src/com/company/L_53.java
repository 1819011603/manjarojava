package com.company;

import java.util.Map;

public class L_53 {
    public int maxSubArray(int[] nums){

        int cur = nums[0];
        int ans =  nums[0];
        for (int i = 1; i < nums.length; i++){
            if (cur<0){
                cur = nums[i];
            }
            else cur+=nums[i];
            ans = Math.max(ans,cur);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new L_53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(new L_53().maxSubArray(new int[]{-2}));
        System.out.println(new L_53().maxSubArray(new int[]{2}));
    }
}
