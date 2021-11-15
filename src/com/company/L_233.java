package com.company;

import java.util.HashMap;

public class L_233 {

    public static   int getM(int n){
        int m = 0;
        while (n > 0){
            m++;
            n/=10;
        }
        return m;
    }
    static  HashMap<Integer, Integer> map;
    public static int countDigitOne(int n) {
        int m = getM(n);
        map = new HashMap<>();
        return dfs(n, m);



    }

    public static  int dfs(int n, int m){
        if (map.containsKey(n)){
            return map.get(n);
        }
        if (m == 1){
            if (n == 0)return 0;
            else return 1;
        }else {

            int pow = (int) Math.pow(10, m - 1);
            int i = n / pow;
            if (i == 0){
                int dfs = dfs(n, m - 1);
                map.put(n,dfs);

                return  dfs;
            }
            else if (i == 1){
                int i1 = n % pow + 1 + dfs(pow - 1, m - 1) + dfs(n % pow, m - 1);
                map.put(n,i1);
                return i1;
            }else {
                int i1 = dfs(n % pow, m - 1) + dfs(pow - 1, m - 1) * i + pow;
                map.put(n,i1);
                return   i1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(18300));
        System.out.println(Integer.bitCount(1024));
    }




}
