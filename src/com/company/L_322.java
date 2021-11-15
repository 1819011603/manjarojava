package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class L_322 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)return 0;
        boolean[] dp = new boolean[amount+1];

        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(0);

        Arrays.sort(coins);
        int l = 0;
        while(queue.size()>0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.pollFirst();

                for(int j: coins){
                    int u = cur+ j ;
                    if (u > amount || dp[u])continue;
                    if (u == amount)return l+1;
                    queue.addLast(u);
                    dp[u] = true;

                }
            }
            l++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new L_322().coinChange(new int[]{1,2,5,7},21));
    }
}
