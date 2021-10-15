package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L_42 {
    public int trap1(int[] height) {


            int n = height.length;
            if (n == 0) {
                return 0;
            }

            int[] leftMax = new int[n];
            leftMax[0] = height[0];
            for (int i = 1; i < n; ++i) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            int[] rightMax = new int[n];
            rightMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return ans;






    }

    // 双指针 模仿leftMax和rightMax数组
    public int trap2(int[] height){
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int left = 0,right = n-1;
        int leftMax = 0,rightMax = 0;
        int ans = 0;
        while (left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(leftMax > rightMax){
                ans+=rightMax-height[right];
                right--;
            }else {
                ans+=leftMax-height[left];
                left++;
            }
        }
        return ans;
    }


    // height数组值递减 存储下标单调栈
    public int trap(int[] height){
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0,cur,pre;
        for (int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[i]>height[stack.peek()]){
                pre = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                cur = stack.peek();

                ans +=( Math.min(height[cur],height[i]) - height[pre]) * (i-cur-1);

            }
            stack.push(i);
        }
        return ans;
    }



    public static void main(String[] args) {
//        System.out.println(new L_42().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
//        System.out.println(new L_42().trap(new int[]{4,2,0,3,2,5}));
//        System.out.println(new L_42().trap(new int[]{5,4,1,2}));
//        System.out.println(new L_42().trap(new int[]{0,1,2,0,3,0,1,2,0,0,4,2,1,2,5,0,1,2,0,2}));
//        System.out.println(new L_42().trap(new int[]{9,6,8,8,5,6,3}));
//        System.out.println(new L_42().trap(new int[]{2,8,5,5,6,1,7,4,5}));
//        System.out.println(new L_42().trap(new int[]{8,9,3,6,9,6,8,0,7,6,8,1}));
        System.out.println(new L_42().trap(new int[]{3,9,8,1,1,4,1,5,1,4,1,1,2}));
        System.out.println(new L_42().trap1(new int[]{3,9,8,1,1,4,1,5,1,4,1,1,2}));
        System.out.println(new L_42().trap(new int[]{1,9,7,1,3,6,4,7,4,8,3,6,3,5,3,7}));
        System.out.println(new L_42().trap1(new int[]{1,9,7,1,3,6,4,7,4,8,3,6,3,5,3,7}));
    }

}
