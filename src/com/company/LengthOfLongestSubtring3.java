package com.company;

import java.util.*;

class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubString(String s){
        if(s.length() <= 1)return s.length();
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int l = -1,ans = 0;
        Integer temp;
        for (int i = 0; i < chars.length; i++){

            if((temp = map.get(chars[i]))!=null){
                if(l == -1){
                    l = temp;

                    ans = Math.max(ans,i - temp);

                }

                else if(chars[i] == chars[l] ){
                    ans = Math.max(ans,i-temp);
                    l = temp;

                }else if(temp > l){
                    ans = Math.max(ans,i-temp);
                    l = temp;

                }else if(temp < l){
                    ans = Math.max(ans, i - l);
                }
            }else {

                ans = Math.max(ans, i - l);

            }
            map.put(chars[i],i);



        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring3().lengthOfLongestSubString("abcabcbb"));
        System.out.println(new LengthOfLongestSubstring3().lengthOfLongestSubString("bbbb"));
        System.out.println(new LengthOfLongestSubstring3().lengthOfLongestSubString("pwwkew"));
        System.out.println(new LengthOfLongestSubstring3().lengthOfLongestSubString(""));
        System.out.println(new LengthOfLongestSubstring3().lengthOfLongestSubString(""));
        System.out.println(new LengthOfLongestSubstring3().lengthOfLongestSubString("tmmzuxt"));
    }
}
