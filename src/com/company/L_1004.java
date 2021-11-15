package com.company;

public class L_1004 {

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n+1];
        for (int i = 0; i < n; i++){
            if (nums[i] == 0){
                pre[i+1] = pre[i]+1;
            }else pre[i+1] = pre[i];
        }

        int l;
        int ans = 0;
        for (int i = 1; i <= n;i++){

            l = binarySearch(pre,0,i,pre[i] - k);
            ans = Math.max(ans,i-l);

        }
        return ans;

    }

    public int binarySearch(int[] nums,int l, int r,int value){
        int mid;
        while (l <= r){
            mid = (l + r) >> 1;
            if (nums[mid] >= value){
                r = mid-1;
            }else l = mid+1;
        }
        return l;
    }
}
