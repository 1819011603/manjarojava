package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup90 {
    private final List<Integer> visited = new ArrayList<>();
    private  List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums){
        ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0);
        return  ans;
    }

    public void dfs(int[] nums,int cur){
        if(cur == nums.length){
            ans.add(new ArrayList<>(visited));
            return;
        }

        visited.add(nums[cur]);
        dfs(nums,cur+1);
        visited.remove(visited.size()-1);

        if(cur > 0 && visited.size() > 0 && nums[cur]==visited.get(visited.size()-1))return;
        dfs(nums,cur+1);
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup90().subsetsWithDup(new int[]{1,2,2}));;
    }
}
