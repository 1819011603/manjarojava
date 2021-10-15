package com.company;

import java.util.Map;

public class Reverse7 {
    public int reverse(int x){
        int t = Math.abs(x);
        long ans = 0;
        while (t != 0){
            ans = ans*10 + t % 10;
            t /= 10;
        }
        if(x < 0)ans = -ans;
        if(ans> Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
            ans = 0;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new Reverse7().reverse(-123));
        System.out.println(new Reverse7().reverse(-123));
        System.out.println(new Reverse7().reverse(-120));
        System.out.println(new Reverse7().reverse(120));
        System.out.println(new Reverse7().reverse(1534236469));
    }
}
