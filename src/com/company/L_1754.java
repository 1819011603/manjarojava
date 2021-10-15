package com.company;

public class L_1754 {
    public String largestMerge(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int l1 = 0,l2 = 0;
        while (l1 < word1.length() && l2 < word2.length()){
            if (word1.charAt(l1) > word2.charAt(l2)){
                ans.append(word1.charAt(l1++));
            }else if (word1.charAt(l1) < word2.charAt(l2)){
                ans.append(word2.charAt(l2++));
            }else {
                if ( word1.substring(l1) .compareTo(word2.substring(l2)) > 0){
                    ans.append(word1.charAt(l1++));
                }else  ans.append(word2.charAt(l2++));
            }
        }

        if (l1 == word1.length()){
            ans.append(word2.substring(l2));
        }else ans.append(word1.substring(l1));

        return ans.toString();


    }



    public static void main(String[] args) {
        System.out.println(new L_1754().largestMerge("abcabc","abdcaba"));
    }
}
