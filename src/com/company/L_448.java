package com.company;

import java.util.ArrayList;
import java.util.List;

public class L_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while ( i < nums.length){
            if (nums[i] == i+1)i++;
            else if (!swap(nums,i,nums[i]-1))i++;
        }
        List<Integer> ans = new ArrayList<>();
        for (i = 0; i < nums.length; i++){
            if (nums[i]-1 != i){
                ans.add(i+1);
            }
        }
        return ans;
    }
    public boolean swap(int[] nums,int l, int r){
        if (nums[l] == nums[r])return false;
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
        return true;
    }
    public static void main(String[] args) {

    }
}
