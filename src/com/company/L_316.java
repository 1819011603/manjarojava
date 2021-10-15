package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class L_316 {
    public String removeDuplicateLetters(String s) {
        int[] map = new int[26];
        StringBuilder ans = new StringBuilder();
        boolean[] vis = new boolean[26];

        for (int i = 0; i < s.length(); i++){
            ++map[s.charAt(i)-'a'];
        }
        char c,b;
        for (int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if(!vis[c-'a']){
                while (ans.length() > 0 && (b = ans.charAt(ans.length()-1)) > c ){
                    if (map[b-'a']> 0){
                        vis[b-'a'] = false;
                        ans.deleteCharAt(ans.length()-1);
                    }else {
                        break;
                    }
                }
                vis[c-'a'] = true;
                ans.append(c);
            }
            map[c-'a']--;

        }


        return ans.toString();

    }
    public static void main(String[] args) {


        System.out.println(new L_316().removeDuplicateLetters("cdadabcc"));
        System.out.println(new L_316().removeDuplicateLetters("bcbac"));
        System.out.println(new L_316().removeDuplicateLetters("abacb"));
        System.out.println(new L_316().removeDuplicateLetters("eabcgdabcdabgcdasdasdasdgfaweftwergadsasdvcfvwdsasdasfagasgrwerfwerawerdw"));
        System.out.println(new L_316().removeDuplicateLetters("eabcgdapofdsodpoasbsadacsdfasdacdabgcdasdasdasdgfaweftwergasdqwerrasdasdsavfdadsasdvgddasdcfvwdsasdasfagasdfadasdasgdasrwerfwasdasrawerdw"));

        System.out.println(new L_316().removeDuplicateLetters("eabcgdabcdabgcd"));
        System.out.println(new L_316().removeDuplicateLetters("cbacdcbc"));
        System.out.println(new L_316().removeDuplicateLetters("cbadcc"));
    }
}
