package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuteUnique47 {

    public Set<List<Integer>> ans;
    public List<Integer> visited = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums){
        ans = new HashSet<>();
        boolean[] vis = new boolean[nums.length];

        dfs(nums,vis);
        return new ArrayList<>(ans);


    }

    public void dfs(int[] nums,boolean[] vis){
        if(visited.size() == nums.length){

            ans.add(new ArrayList<>(visited));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if(!vis[i]){
                vis[i] = true;
                visited.add(nums[i]);
                dfs(nums,vis);
                visited.remove(visited.size()-1);
                vis[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println( new PermuteUnique47().permuteUnique(new int[]{1,2,3}));
    }
}
