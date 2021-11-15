package com.company;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L_2064 {
    public static int minimizedMaximum(int n, int[] quantities) {
        int l = 1,r = Arrays.stream(quantities).max().getAsInt();
        int mid;
        while (l <= r){
            mid = (l+r)>>1;
            int m = 0;
            for (int i : quantities){
                m += (i-1) / mid+1;
            }
            if (m > n){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(minimizedMaximum(6,new int[]{11,6}));
        Deque<Integer> s = new LinkedList<>();

    }
}
