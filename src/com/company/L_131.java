package com.company;

import java.util.ArrayList;
import java.util.List;

public class L_131 {

    List<List<String>> ans = new ArrayList<>();
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        dp= new boolean[s.length()][s.length()];
        int[] t = new int[s.length()];
        for (int l = 1; l <= s.length(); l++){
            int m = s.length() -l;
            for (int j =0; j <= m; j++){
                if (l == 1){
                    dp[j][j] = true;
                    t[j] = l;
                }else if (l == 2 && s.charAt(j) == s.charAt(j+1)){
                    dp[j][j+1]  =true;
                    t[j] = l;
                }else {

                    if (s.charAt(j) == s.charAt(j+l-1) && dp[j+1][j+l-2]){
                        dp[j][j+l-1] = true;
                        t[j] = l;
                    }
                }
            }
        }

        dfs(s,t,0,new ArrayList<>());
        return ans;

    }

    public void dfs(String s,int[] t,int l,List<String> cur){
        if (l == s.length()){
            ans.add(new ArrayList<>(cur));
            return;
        }
        int m = t[l];
        do {
            if (dp[l][l+m-1]){
                cur.add(s.substring(l,l+m));
                dfs(s,t,l+m,cur);
                cur.remove(cur.size()-1);
            }
            m--;
        }while (m > 0);


    }
    public static void main(String[] args) {
        System.out.println(new L_131().partition("ababa"));
    }
}
