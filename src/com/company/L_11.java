package com.company;

public class L_11 {
    public int maxArea(int[] height) {
        int left = 0,right = height.length-1;

        int ans = 0;
        while (left < right){


            ans = Math.max(ans, (right-left)*Math.min(height[left],height[right]));
            if (height[left] > height[right])right--;
            else left++;

            }


        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new L_11().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(new L_11().maxArea(new int[]{1,1}));
        System.out.println(new L_11().maxArea(new int[]{1,2,1}));
        System.out.println(new L_11().maxArea(new int[]{4,3,2,1,4}));
    }
}
