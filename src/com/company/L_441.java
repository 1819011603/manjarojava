package com.company;

public class L_441 {

    public int arrangeCoins(int n) {
        long u = (long)n<<1;
        long i = (long) Math.sqrt(u);
        long t = i*(i+1);
        if (t > u){
            i--;
        }
        return (int) i;

    }

    public static void main(String[] args) {
        System.out.println(new L_441().arrangeCoins(2147483647));
        System.out.println(new L_441().arrangeCoins(6));
        System.out.println(new L_441().arrangeCoins(7));
        System.out.println(new L_441().arrangeCoins(8));
        System.out.println(new L_441().arrangeCoins(9));
        System.out.println(new L_441().arrangeCoins(10));
    }
}
