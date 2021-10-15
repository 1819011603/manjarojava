package com.company;

public class L_55 {
    public boolean canJump(int[] nums) {
        int r = 0;
        int last = 0;
        int i = 0;
        while (last < nums.length-1){
            while (i <= r && last < nums.length-1){
                last = Math.max(i+nums[i],last);
                i++;
            }
            if(r == last){
                return false;
            }
            r = last;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L_55().canJump(new int[]{3,2,1,0,4}));
        System.out.println(new L_55().canJump(new int[]{2,3,1,1,4}));
    }
}
