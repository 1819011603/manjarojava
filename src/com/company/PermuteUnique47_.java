package com.company;

import java.util.*;

public class PermuteUnique47_ {

    public List<List<Integer>> ans;
    public List<Integer> visited = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums){
        ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,vis,0);
        return ans;


    }

    public void dfs(int[] nums,boolean[] vis,int index){
        if(index == nums.length){

            ans.add(new ArrayList<>(visited));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            // 如果前面那个相等的元素还没有被访问 相等的元素中：访问顺序只能是从第一个相同元素到最后一个元素
            // O** -> OO* ->OOO
            // OOOO*OOO*  这是不可能的 因为第六个元素的前面一个元素没有访问  它是会被剪枝的 continue掉的
            if(vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1]))continue;

                vis[i] = true;
                visited.add(nums[i]);
                dfs(nums,vis,index+1);
                visited.remove(visited.size()-1);
                vis[i] = false;

        }
    }
    public static void main(String[] args) {
        System.out.println( new PermuteUnique47_().permuteUnique(new int[]{1,2,1}));
    }
}
