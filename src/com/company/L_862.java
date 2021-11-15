package com.company;

public class L_862 {

    public int shortestSubarray(int[] nums, int k) {
        int l = 0,r = 0;
        int len = nums.length;
        long sum = 0;
        int[] dp = new int[nums.length+1];
        int ans = Integer.MAX_VALUE;
        while (r < len){
            sum +=  nums[r];
            if (nums[r] < 0)
            {
                int p = nums[r];
                for (int u = r-1; u>= l; u--){
                    p+=nums[u];
                    if (p < 0){
                        dp[u+1] = 0;
                    }
                }
                dp[r+1] = -1;
                ++r;
                continue;
            }
            if(sum < k){
                r++;
                continue;
            }

            while (l < r &&( sum>= k || dp[l+1] == -1 )){
                sum-=nums[l++];
            }

            r++;
            ans = Math.min(ans,r-l+1);


        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }

    public static void main(String[] args) {
        System.out.println(new L_862().shortestSubarray(new int[]{84,-37,32,40,95},167));
    }
}
