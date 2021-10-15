package com.company;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class O_38 {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] ans = new int[temperatures.length];
        Deque<Integer> maxStack = new LinkedList<>();

        for (int i = 0; i < temperatures.length; i++){
            if (maxStack.isEmpty() || temperatures[maxStack.peek()] > temperatures[i]){
                maxStack.push(i);
            }else {

                while (!maxStack.isEmpty() && temperatures[maxStack.peek()] <= temperatures[i]){
                    Integer pop = maxStack.pop();
                    ans[pop] = i-pop;
                }
                maxStack.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new O_38().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
