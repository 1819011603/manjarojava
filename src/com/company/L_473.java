package com.company;

public class L_473 {

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < matchsticks.length; i++){
            sum+= matchsticks[i];
            if(max < matchsticks[i]) max = matchsticks[i];
            if (min > matchsticks[i]) min = matchsticks[i];
        }
        int v = min/4*4;
        for(int i = 0; i < matchsticks.length; i++){
            matchsticks[i] -= v;
        }
        sum -= v*matchsticks.length;
        if(sum % 4 != 0 || sum/4 < max)return false;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

            for (int j:matchsticks){
                for (int i = sum; i >= min; i--){
                if (i-j>=0){
                    dp[i] = dp[i] | dp[i-j];
                }
            }
        }

        return dp[sum/4] && dp[sum/2] && dp[sum/4*3] && dp[sum];
    }


    public static void main(String[] args) {
        System.out.println(new L_473().makesquare(new int[]{1569462,2402351,9513693,2220521,7730020,7930469,1040519,5767807,876240,350944,4674663,4809943,8379742,3517287,8034755}));
    }
}
