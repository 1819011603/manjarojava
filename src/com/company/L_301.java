package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L_301 {
    List<String> ans = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int sum = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                sum++;
            }else if (s.charAt(i) == ')'){
                sum--;
                if (sum < 0){
                    r++;
                    sum = 0;
                }
            }
        }
        helper(s,0,0,0,sum,r);
        return ans;


    }

    private void helper(String str, int start, int lcount, int rcount, int lremove, int rremove){
        if (lremove == 0 && rremove == 0) {
            if (isValid(str)) {
                ans.add(str);
            }
            return;
        }

        for (int i = start; i < str.length(); i++){
            if (i!= start && str.charAt(i) == str.charAt(i-1)){
                continue;
            }

            if (lremove + rremove > str.length() - i)return;
            if (lremove > 0 && str.charAt(i) == '('){
                helper(str.substring(0,i) + str.substring(i+1),i,lcount,rcount,lremove-1,rremove);
            }
            if (rremove > 0 && str.charAt(i) == ')'){
                helper(str.substring(0,i) + str.substring(i+1),i,lcount,rcount,lremove,rremove-1);
            }
            if (str.charAt(i) == '(') {
                lcount++;
            }else if(str.charAt(i) == ')')rcount++;
            if (rcount > lcount) {
                break;
            }

        }
    }
    private boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else if (str.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }

        return cnt == 0;
    }

    public static void main(String[] args) {
        System.out.println(new L_301().removeInvalidParentheses(
                "()())()"));
    }

}
