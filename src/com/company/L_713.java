package com.company;

import java.util.ArrayList;
import java.util.List;

public class L_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0,r = 0;
        long temp = 1;
        int ans = 0;

        while (r < nums.length){

            temp *= nums[r++];

            while (temp >= k){
                temp/=nums[l++];
            }
            ans+= r-l;



        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new L_713().numSubarrayProductLessThanK(new int[]{10,5,2,6},100));
    }

}
