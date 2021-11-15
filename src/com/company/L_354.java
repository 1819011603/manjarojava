package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class L_354 {


    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){

                    return Integer.compare(o2[1],o1[1]);
                }
                return Integer.compare(o1[0],o2[0]);
            }
        });
        int[] dp = new int[envelopes.length+1];
        int ans = 1;
        int pre = 0;
        for (int i = 0; i < envelopes.length; i++){
            dp[i] = 1;
        }
        for (int i = 1;i < envelopes.length; i++){
            for (int j = 0; j < i; j++){
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    ans = Math.max(ans,dp[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
