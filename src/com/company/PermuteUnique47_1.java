package com.company;

import java.util.*;

public class PermuteUnique47_1 {

    public List<List<Integer>> ans;
    public List<Integer> visited = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums){
        ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,vis);
        return ans;


    }

    public void dfs(int[] nums,boolean[] vis){
        if(visited.size() == nums.length){

            ans.add(new ArrayList<>(visited));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if(vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1]))continue;

                vis[i] = true;
                visited.add(nums[i]);
                dfs(nums,vis);
                visited.remove(visited.size()-1);
                vis[i] = false;

        }
    }
    public static void main(String[] args) {
        System.out.println( new PermuteUnique47_1().permuteUnique(new int[]{1,2,1}));
    }
}
