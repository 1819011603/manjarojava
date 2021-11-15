package com.company;

public class L_567 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int m = s1.length();
        if (n < m)return false;
        int[] t = new int[128];
        for (int i = 0; i < m; i++){
            t[s1.charAt(i)]--;
        }
        char[] chars = s2.toCharArray();
        int l = 0,r=0;

        int i = 0;
        while (r < n){
            if (++t[chars[r++]]  <= 0){
                if(++i == m){
                    return true;
                }
            }else {
               while (t[chars[r-1]] > 0 ){
                  if (--t[chars[l++]] < 0)
                   i--;
               }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new L_567().checkInclusion("ab", "eidbaooo"));
    }
}
