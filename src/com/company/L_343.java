package com.company;

public class L_343 {
    public static int integerBreak(int n) {
        if(n <= 3)return n-1;
        if(n % 3 == 0){
            return (int) Math.pow(3,n/3);
        }else if( n % 3 == 2){
            return (int) Math.pow(3,n/3) * 2;
        }else  {
            return (int) Math.pow(3,n/3-1) * 4 ;
        }
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(18));
    }
}
