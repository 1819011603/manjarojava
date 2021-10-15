package com.company;

public class L_44 {
    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        boolean[][] dp= new boolean[n1+1][n2+1];
        dp[0][0] = true;
        int i,j;
        for (j = 1; j <= n2; j++){
            if (p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1] ;
            }
        }

        for (i = 1;i <= n1; i++){
            for (j = 1; j <= n2; j++){
                if (p.charAt(j-1) == '*'){
                    // p中*直接去掉
                    dp[i][j] = dp[i][j-1] |  dp[i-1][j];

                        // *匹配多个字符 一次一个字符  相当于删掉i中最后一个字符


                }else {
                    if(match(s,p,i,j)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[n1][n2];
    }
    public boolean match(String s,String p,int i, int j){
         if(p.charAt(j-1) == '?'){
            return s.length() != 0;
        }
        else if (p.charAt(j-1) == '*'){
            return true;
        }else return s.charAt(i-1) == p.charAt(j-1);
    }


    public static void main(String[] args) {
        System.out.println(new L_44().isMatch("abcde","*a*b"));
        System.out.println(new L_44().isMatch("abcdb","*a*b"));
    }
}
