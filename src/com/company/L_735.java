package com.company;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L_735 {


    public int[] asteroidCollision(int[] asteroids) {

        boolean f;
        int integer1,integer;
        Deque<Integer> stack = new LinkedList<>();
        for (int i: asteroids){
            f = false;

            while (stack.size() > 0 &&  (integer1  = stack.peekLast()) > 0 && i < 0 && integer1 + i <= 0){

                integer = stack.pollLast();
                if (i + integer == 0){
                    f = true;
                    break;
                }
            }
            if (f || (stack.size() > 0 && i < 0 && stack.peekLast() * i < 0)) continue;
            stack.addLast(i);
        }
        int[] ans = new int[stack.size()];
        int k = 0;
        while (stack.size() > 0){
            ans[k++] = stack.pollFirst();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L_735().asteroidCollision(new int[]{-2,-1,1,2,6,-7,4,5,-6,43,-54,32,34,-3,-4,8,1})));
    }
}
