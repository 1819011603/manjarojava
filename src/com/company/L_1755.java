package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class L_1755 {
    int start;

    public int binarySearch(int[] nums,int l,int r,int value){
        int mid;
        while (l <=r){
            mid = (l+r)>>1;
            if (nums[mid] < value){
                l = mid+1;
            }else r = mid-1;
        }
        if (l == nums.length || l > 0 && Math.abs(nums[l]-value) > Math.abs(nums[r]-value) ){
            return r;
        }
        return l;

    }
    int ans = Integer.MAX_VALUE;
    public int minAbsDifference(int[] nums, int goal) {
        int len = nums.length;
        int[] pre = new int[(int) Math.pow(2,len/2)];
        start = 0;
        dfs(nums,pre,0,len/2,0);
        Arrays.sort(pre);
        dfs1(nums,pre,len/2,len,0,goal);

        return ans;
    }

    public void dfs(int[] nums,int[] pre, int l, int len,int sum){
        if (len == l){
            pre[start++] = sum;
            return;
        }
        dfs(nums,pre,l+1,len,sum+nums[l]);
        dfs(nums,pre,l+1,len,sum);
    }

    public void dfs1(int[] nums,int[] pre, int l, int len,int sum,int goal){
        if (len == l){
            int i = binarySearch(pre, 0, pre.length - 1, goal - sum);
            ans = Math.min(ans,Math.abs(pre[i] + sum - goal));
            return;
        }
        dfs1(nums,pre,l+1,len,sum+nums[l],goal);
        dfs1(nums,pre,l+1,len,sum,goal);
    }


    public static void main(String[] args) {
        System.out.println(new L_1755().minAbsDifference(new int[]{7,-9,15,-2},-5));
        System.out.println(new L_1755().minAbsDifference(new int[]{5,-7,3,5},6));
    }
}
