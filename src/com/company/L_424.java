package com.company;

import java.util.HashSet;
import java.util.Set;

public class L_424 {

    public int characterReplacement(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            set.add(chars[i]);
        }


        for (char i : set){
            int j = 0;
            int u = 0;
            int l = 0;
            while ( j < n){
                if (chars[j++] !=  i){
                    ++u;
                }

                if (u > k && chars[l++] !=  i){
                    u--;
                }
            }
            ans = Math.max(ans,j- l);
        }


        return ans;
    }

    public static void main(String[] args) {

    }
}
