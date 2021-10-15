package com.company;

public class LongestPalindrome5 {
    public String longestPalindrome(String s) {
        int l = 0,r = 1,n = s.length();
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int len = 1; len <= n; len++){
            for (int i = 0; i < n-len+1; i++){
                if(len == 1){
                    dp[i][i] = 1;
                }else if(len == 2 && s.charAt(i) == s.charAt(i+1)){

                    dp[i][i+1] = len;
                    if(ans < len){
                        ans = len;
                        l = i;
                        r = i+len;
                    }
                }else  {
                    if(dp[i+1][i+len-2] != 0 && s.charAt(i) == s.charAt(i+len-1)){


                            dp[i][i+len-1] = len;
                            if(ans < len){
                                ans = len;
                                l = i;
                                r = i+len;
                            }


                    }
                }
            }
        }
        return s.substring(l,r);

    }

    public static void main(String[] args) {
        String ans = new LongestPalindrome5().longestPalindrome("abbadasadd");
        System.out.println(ans);
    }
}
