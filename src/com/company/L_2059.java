package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L_2059 {


    public int minimumOperations(int[] nums, int start, int goal) {
        boolean[] vis = new boolean[1001];
        Deque<Integer> deque = new ArrayDeque<>(1005),d =  new ArrayDeque<>(1005),tmp;
        deque.add(start);
        int l = 0;
        while (deque.size() > 0){

            while (deque.size() > 0){
                int i = deque.pollFirst();
                for (int j : nums){
                    int i1 = i + j;
                    int i2 = i - j;
                    int i3 = i ^ j;
                    if (i1 == goal || i2 == goal || i3 == goal){
                        return l+1;
                    }

                    if ( i1 >= 0 && i1 < 1001 && !vis[i1]  ){
                        vis[i1] = true;
                        d.addLast(i1);
                    }
                    if (i >=j && i2 <= 1000 && !vis[i2] ){
                        vis[i2] = true;
                        d.addLast(i2);
                    }

                    if ( i3 >= 0 && i3 < 1001 && !vis[i3] ){
                        vis[i3] = true;
                        d.addLast(i3);
                    }

                }
            }
            tmp = deque;
            deque = d;
            d = tmp;
        }
        return -1;
    }



    public static void main(String[] args) {
//        System.out.println(new L_2059().minimumOperations(new int[]{1,3},6,4));
        System.out.println(new L_2059().minimumOperations(new int[]{3,5,7},0,-4));
    }
}
