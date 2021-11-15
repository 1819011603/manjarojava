package com.company;

import java.util.ArrayList;
import java.util.List;

public class L_78 {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums,0,new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums,int l,List<Integer> cur){
        if (l == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        dfs(nums,l+1,cur);
        cur.add(nums[l]);
        dfs(nums,l+1,cur);
        cur.remove(cur.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(new L_78().subsets(new int[]{1,2,3}));
    }
}
