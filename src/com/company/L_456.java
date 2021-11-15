package com.company;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class L_456 {
//
//    boolean findValue(int[] nums1,int[] nums2,int i,int[] value){
//        int min = nums1[0];
//
//    }
//    public int binary(int[] nums,int l,int r,int v){
//        int mid;
//        int t = r;
//        boolean f = false;
//        while (l <= r){
//            mid = (l+r)>>1;
//            if (nums[mid] > v){
//                r = mid-1;
//            }else if (nums[mid] < v){
//                l = mid+1;
//            }else {
//                f = true;
//                l = mid+1;
//            }
//        }
//        return f?binary(nums,l,t,nums[l]):l;
//    }
    public boolean find132pattern(int [] nums){
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = max[0] = nums[0];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < max[i-1] && nums[i] > min[i-1])return true;
            for (int l:list){
                if (nums[i] > min[l] && nums[i] < max[l])return true;
            }
            if (nums[i] <= min[i-1]){
                list.add(i-1);
                max[i] = min[i] = nums[i];
            }else if (nums[i] > max[i-1]){

                min[i] = min[i-1];
                max[i] = nums[i];

//                map.put(min[i],max[i]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new L_456().find132pattern(new int[]{3,5,0,3,4}));
    }
}
