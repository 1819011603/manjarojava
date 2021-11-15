package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L_869 {
    public  static int hhh(int n){
        n = n | n >>1;
        n = n | n >>2;
        n = n | n >>4;
        n = n | n >>8;
        n = n | n >>16;
        return n+1;
    }
    public static boolean reorderedPowerOf2(int n) {
        int k = (int) Math.min((long) n * 10, (int) 1e9);
        int i = hhh(n/10),j;
        k = hhh(k)>>1;
        int[] ints = new int[10];
        while (n > 0){
            ints[n % 10]++;
            n/=10;
        }

        while (i <= k){
            j = i;
            int[] s= new int[10];
            while (j > 0){
                s[j%10]++;
                j/=10;
            }
            boolean pp = false;
            for (int p = 0; p < 10; p++){
                if (s[p] != ints[p]){
                    pp = true;
                    break;
                }
            }
            if (!pp)return true;
            i <<= 1;
        }


        return false;

    }
    public static void main(String[] args) {

        System.out.println(reorderedPowerOf2(822177413));
        System.out.println(1<<27);

    }
}
