package com.company;

import java.util.Arrays;
import java.util.Map;

public class Jump45 {
    public int jump(int[] nums){
        int last = 0;
        int u = 0;
        int r = 0;
        int i = 0;
        while (last < nums.length-1){
            while (i <= r && last < nums.length-1){
                last = Math.max(i+nums[i],last);
                i++;
            }
            r = last;
            u++;
        }

        return u;
    }
    public static void main(String[] args) {
        System.out.println(new Jump45().jump(new int[]{2,3,1,1,4}));
        System.out.println(new Jump45().jump(new int[]{2,3,0,1,4}));
        System.out.println(new Jump45().jump(new int[]{2,2,0,1}));
        System.out.println(new Jump45().jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));

    }
}
