package com.company;

public class L_673 {
    public int binarySearch(int[] nums,int l, int r,int value){
        int mid;
        while(l <= r){
            mid = (l+r)>>1;
            if(nums[mid] >= value){
                r = mid-1;
            }else l = mid+1;
        }
        return l;
    }
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0)return 0;
        int[] min = new int[nums.length];
        int[] dp = new int[nums.length+1];
        int cur = -1;
        min[0] = Integer.MAX_VALUE;
        dp[0] = 1;
        for(int i = 1; i <= nums.length; i++){
            int search = binarySearch(min,0,cur,nums[i-1]);
            if(search > cur)cur++;
            dp[search+1] += dp[search];
            min[search] = nums[i-1];
        }
        return dp[cur+1];


    }
    public static void main(String[] args) {
        System.out.println(new L_673().findNumberOfLIS(new int[]{2,2,2,2,2}));
    }
}
