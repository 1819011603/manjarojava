package com.company;

import java.util.HashMap;
import java.util.TreeMap;

public class L_1296 {
    public static boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0)return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i: nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int first,value,time,f;
        Integer v;
        while (!map.isEmpty()){
            time = k-1;
            first = map.firstKey();
            value = map.get(first);
            map.remove(first);
            while(time--!=0){
                f = first+1;
                v = map.get(f);
                if (f != first+1 ||v == null ||  v < value){
                    return false;
                }
                if (v == value){
                    map.remove(f);
                }else
                map.put(f,v-value);
                first = f;
            }


        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11},3));
    }
}
