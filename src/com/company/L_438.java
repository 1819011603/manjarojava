package com.company;

import java.util.ArrayList;
import java.util.List;

public class L_438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length())return new ArrayList<>();

        int[] cur = new int[128];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < p.length(); i++){
            cur[p.charAt(i)]--;
        }
        char[] chars = s.toCharArray();
        int count = 0;
        int l = 0;
        int i;
        for (i = 0; i < chars.length; i++){
            if (++cur[chars[i]] <= 0){
                count++;
                if (count == p.length()){
                    ans.add(l);
                }else continue;
                --cur[s.charAt(l++)];
                count--;


            }else {


                while (l <= i && cur[chars[i]] > 0){
                    if(cur[chars[l]] <= 0)
                    count--;
                    --cur[chars[l++]];
                }



            }
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new L_438().findAnagrams("aaabaaa","aaa"));
    }
}
