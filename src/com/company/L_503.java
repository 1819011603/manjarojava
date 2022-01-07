package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L_503 {
    public int[] nextGreaterElements(int[] nums) {

        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i <= 2*nums.length-1; i++){

            while (stack.size() > 0 && nums[stack.peekLast()] <= nums[i]){
                nums[stack.pollLast()] = nums[i];
            }
            stack.addLast(i);
        }
        return ans;
    }
}
