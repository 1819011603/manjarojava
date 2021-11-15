package com.company;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class L_76 {
    public String minWindow(String s, String t) {
        int tl = t.length();
        int sl = s.length();
        if (sl < tl)return "";
        int[] time = new int[126];

        for (int i = 0; i < tl; i++){
            time[t.charAt(i)]++;
        }
        char[] chars = s.toCharArray();
        Deque<Integer> q = new LinkedList<>();
        int l = -1;
        String ans = null;
        int[] te = new int[126];
        for (int i = 0; i < sl; i++){
            if (time[chars[i]] != 0){
                if (l == -1){
                    l = i;
                }
                te[chars[i]]++;
                q.addLast(i);
                if (compare(te,time)){
                    if (ans == null || ans.length() > (i-l+1)){
                        ans = s.substring(l,i+1);
                    }
                    while (!q.isEmpty() &&  te[chars[q.peekFirst()]] >  time[chars[q.peekFirst()]]){
                        te[chars[q.pollFirst()]]--;

                        l = q.peekFirst();

                        if (compare(te,time) && ans.length() > i-l+1){
                            ans = s.substring(l,i+1);
                        }
                    }
                }else {
                    while (!q.isEmpty() && te[chars[q.peekFirst()]]> time[chars[q.peekFirst()]]){
                        te[chars[q.pollFirst()]]--;
                        l = q.peekFirst();
                    }
                }



            }
        }

        return ans == null?"":ans;




    }

    public boolean compare(int[] n,int[] m){
        for (int i = 65; i < m.length; i++){
            if (m[i] > n[i])return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L_76().minWindow("ADOBECODEBANC","ABC"));
        System.out.println(new L_76().minWindow("a","a"));
        System.out.println(new L_76().minWindow("a","aa"));
        System.out.println(new L_76().minWindow("ab","b"));
        System.out.println(new L_76().minWindow("acbbaca","aba"));
    }
}
