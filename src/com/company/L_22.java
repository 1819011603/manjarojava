package com.company;

import java.util.ArrayList;
import java.util.List;

public class L_22 {
    List<String> ans = new ArrayList<>();
    StringBuilder cur = new StringBuilder();
    public List<String> generateParenthesis(int n){
        dfs(n, n);
        return ans;
    }

    public void dfs(int l, int r){
        if (l+ r == 0){
            ans.add(cur.toString());
            return;
        }
        if(l > 0){
            cur.append("(");
            dfs(l-1,r);
            cur.deleteCharAt(cur.length()-1);
        }

        if ( r > l){
            cur.append(")");
            dfs(l,r-1);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new L_22().generateParenthesis(3));
        System.out.println(new L_22().generateParenthesis(1));
        System.out.println(new L_22().generateParenthesis(8));
    }
}
