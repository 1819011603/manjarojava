package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class L_140 {
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {

        char[] chars = s.toCharArray();
        bfs(chars,0,wordDict,new StringBuilder());
        return ans;
    }

    public void bfs(char[] chars,int l,List<String> wordDict,StringBuilder cur){
        if (l == chars.length){
            cur.deleteCharAt(cur.length()-1);
            ans.add(cur.toString());
            return;
        }else if(l > chars.length){
            return;
        }else {

            for (String s:wordDict){
                if (compareString(chars,l,s)){
                    int len = cur.length();
                    cur.append(s).append(" ");
                    bfs(chars,l+s.length(),wordDict,cur);
                    cur.setLength(len);

                }
            }

        }
    }
    public boolean compareString(char[] chars,int l,String s){
        int len = chars.length-l;
        int length = s.length();
        if (len < length)return false;
        int i = 0;
        while (i < length){
            if (chars[l+i] != s.charAt(i++))return false;

        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"apple", "pen", "applepen", "pine", "pineapple"};

        System.out.println(new L_140().wordBreak("pineapplepenapple", Arrays.asList(strings)));
    }

}
