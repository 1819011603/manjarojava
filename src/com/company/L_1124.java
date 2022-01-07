package com.company;

public class L_1124 {
    public int longestWPI(int[] hours) {

        int[] dp = new int[hours.length+1];
        int ans = 0;
        int min = 0;
        int min_j = 0;
        int[] m = new int[dp.length+1];
        int start = 0;
        m[0] = 0;
        for(int i = 1; i < dp.length; i++){
            dp[i] = dp[i-1] + (hours[i-1] > 8?1:-1);
            if(dp[m[start]] > dp[i]){
                m[++start] = i;
            }

            ans = Math.max(ans,i-binary(dp,m,0,start,dp[i]-1));

        }

        return ans;
    }

    int binary(int[] dp,int[] nums, int start,int end,int v){
        int mid;
        int p = end;

        while(start <= end){
            mid = (start + end)>>1;
            if(dp[nums[mid]] > v){
                start = mid+1;
            }else end = mid-1;
        }
        return start > p ? 100000:nums[start];
    }
    public static void main(String[] args) {
        System.out.println(new L_1124().longestWPI(new int[]{9,9,6,0,9,6,7,9}));;
    }
}
