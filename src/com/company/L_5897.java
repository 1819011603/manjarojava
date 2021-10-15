package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L_5897 {
    int ans;
    int len;

    public int minimumDifference(int[] nums) {

        len = nums.length>>1;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= len ;i++){
            lists.add(new ArrayList<>());
        }
        ans = Integer.MAX_VALUE;
        int sum = Arrays.stream(nums).sum();
        dfs(nums,lists,0,0,0);
        for (List<Integer> l: lists){
            l.sort(Integer::compareTo);
        }
        len = nums.length;
        dfs1(nums,lists,len/2,0,0,sum);


        return ans;
    }

    public int binarySearch(List<Integer> nums,int l,int r,int value){
        int mid;
        while (l <=r){
            mid = (l+r)>>1;
            if (nums.get(mid) < value){
                l = mid+1;
            }else r = mid-1;
        }
        if (l == nums.size() || (l > 0 && Math.abs(nums.get(l)-value) > Math.abs(nums.get(r)-value)) ){
            return r;
        }
        return l;

    }
    public void dfs(int[] nums,List<List<Integer>> pre,int l, int cur,int num){
        if (l == len){
            pre.get(num).add(cur);
            return;
        }
        dfs(nums,pre,l+1,cur+nums[l],num+1);
        dfs(nums,pre,l+1,cur,num);
    }

    public void dfs1(int[] nums,List<List<Integer>> pre,int l, int cur,int num,int sum){
        if (l == len){
            List<Integer> list = pre.get(nums.length / 2 - num);
            int i = binarySearch(list,0,list.size()-1,sum/2-cur);
            ans = Math.min(ans,Math.abs(sum-(list.get(i)+cur)*2));
            return;

        }
        dfs1(nums,pre,l+1,cur+nums[l],num+1,sum);
        dfs1(nums,pre,l+1,cur,num,sum);
    }

    public static void main(String[] args) {
//        System.out.println(new L_5897().minimumDifference(new int[]{3,9,7,3}));
        System.out.println(new L_5897().minimumDifference(new int[]{2,-1,0,4,-2,-9}));
        System.out.println(new L_5897().minimumDifference(new int[]{-79408,72151,-59916,-43654,-35338,90524,64474,-96049,73324,-37996,8054,-5728,2877,49501,-93206,18050}));
    }
}
