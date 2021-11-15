package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class L_395 {
    char[] chars;
    public int longestSubstring(String s, int k){

        chars = s.toCharArray();
        int[] t = new int[128];
        int kinds  = 0;
        for (int i = 0; i< chars.length ;i++){
            if (t[chars[i]]++ == 0){
                kinds++;
            }
        }
        int ans= 0;
        int u = kinds;
        for (int i = 1; i <= u; i++){
            int r = 0;
            int l = 0;
            kinds = 0;
            Arrays.fill(t,0);
            while (r < chars.length){
                if (t[chars[r++]]++ == 0){
                    kinds++;
                    while (kinds > i){
                        if (--t[chars[l++]] == 0){
                            kinds--;
                        }
                    }

                        boolean b = false;
                        for (int v= 'a'; v<= 'z'; v++){
                            if (t[v]!= 0 && t[v]<k){
                                b = true;
                                break;
                            }
                        }
                        if (!b)ans = Math.max(ans,r-l);

                }else {

                    boolean b = false;
                    for (int v= 'a'; v<= 'z'; v++){
                        if (t[v]!= 0 && t[v]<k){
                            b = true;
                            break;
                        }
                    }
                    if (!b)ans = Math.max(ans,r-l);

                }

            }
        }
        return ans;


    }

    public int dfs(int k, int u, int v){
        if (v-u+1 < k)return 0;
        int[] t = new int[128];
        for (int i = u; i<= v ;i++){
            t[chars[i]]++;
        }

        int min = Integer.MAX_VALUE;
        int j = 'a';
        for (int i = 'a'; i <= 'z';i++){
            if (t[i] != 0 && min > t[i]){
                min = t[i];
                j = i;
            }
        }
        if (min >= k)return v-u+1;
        char d = (char)j;
        int e = u;  int ans = 0;
        for (int i = u; i<= v ;i++){
            if (chars[i] == d){
                ans = Math.max(ans,dfs(k,e,i-1));
                e = i+1;
            }
        }
        return Math.max(ans,dfs(k,e,v));
    }

    public static void main(String[] args) {
        System.out.println(new L_395().longestSubstring("aaaaaaaaabbbcccccddddd",
                5));
        System.out.println(new L_395().longestSubstring("weitong",2));
    }


}
