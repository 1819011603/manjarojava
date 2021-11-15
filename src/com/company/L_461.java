package com.company;

public class L_461 {
    public static int hammingDistance(int x, int y) {
        int t = x^y;
        int ans = 0;
        while(t > 0){
            if((t & 1) == 1)ans++;
            t>>=1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(2147483647,14));
    }
}
