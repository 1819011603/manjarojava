package com.company;

public class O_58 {

    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        int r = 0;
        while (r < chars.length && chars[r] == ' '){
            ++r;
        }
        int l = r;
        while (r < chars.length){
            while (r < chars.length && chars[r] != ' '){
                r++;
            }

            ans.insert( 0, chars,l,r-l).insert(r-l, ' ');
            while (r < chars.length && chars[r] == ' '){
                if (chars[r] == ' ')++r;
            }
            l = r;
        }
        ans.setLength(ans.length()-1);

        return ans.toString();

    }
}
