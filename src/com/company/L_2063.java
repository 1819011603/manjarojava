package com.company;

import java.util.Arrays;
import java.util.HashSet;

public class L_2063 {

    public long countVowels(String word) {
        long ans = 0;
        int sum = 0;
        long m = 0;

        Character[] characters = new Character[]{'a','e','i','o','u'};
        HashSet<Character> set = new HashSet<>(Arrays.asList(characters));
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++){

            if (set.contains(chars[i])){

                sum++;
            }

            ans+= (long)sum*(i+1) - m;
            m+= sum;

        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
