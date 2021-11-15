package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L_229 {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int l = nums.length/3;
        for (int i = 0; i < nums.length; i++){
            int i1 = map.getOrDefault(nums[i], 0) + 1;
            if (i1 > l){
                ans.add(nums[i]);
                if (ans.size() == 2)return ans;
            }
            map.put(nums[i],i1);
        }

        return ans;
    }
    public static void main(String[] args) {

    }
}
