package com.company;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L_321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        return null;
    }

    public Deque<Integer> getStack(int[] nums1){
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++){
            if (stack.isEmpty()){
                stack.addLast(nums1[i]);
            }else {
                while (!stack.isEmpty() && stack.peekLast() < nums1[i]){
                    stack.pollLast();
                }
                stack.addLast(nums1[i]);
            }
        }
        return stack;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L_321().maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
    }
}
