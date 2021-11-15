package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L_1922 {
    static int mod = 1000000007;
    public static int countGoodNumbers(long n) {
        if(n == 1)return 5;
        long sum = 1;
        if (n % 2 == 1){
            sum = 5;
        }

        long c = dfs(n >> 1) % mod;
        return (int) ((sum * c) % mod);



    }

    public  static  long dfs(long n){

            if (n == 1)return 20;
            if(n % 2 == 1){
                long a = dfs(n >> 1) % mod;
                return   (a * a ) % mod * 20 % mod;
            }
            long a = dfs(n >> 1) % mod;
            return  (a * a) % mod;

    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(6));
        System.out.println(countGoodNumbers(8));
        System.out.println(countGoodNumbers(10));
        System.out.println(countGoodNumbers(12));
        System.out.println(countGoodNumbers(14));
        System.out.println(countGoodNumbers(16));
        System.out.println(countGoodNumbers(30));
        Deque<TreeNode> queue = new LinkedList();

    }

}
