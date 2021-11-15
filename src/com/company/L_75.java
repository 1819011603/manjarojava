package com.company;

import java.util.Arrays;

public class L_75 {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length-1;
        int mid = l;
        while (mid <= r){
            if (nums[mid] == 0){
                swap(nums,l++,mid++);
            }else if (nums[mid] == 2){
                swap(nums,r--,mid);
                while (r>= mid && nums[r] == 2)
                    r--;
            }else mid++;
        }
    }
    public void swap(int[] nums,int l, int r){
        if (nums[l] == nums[r])return;
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,2,2,1,1,2,1,2,0,1};
        new L_75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
