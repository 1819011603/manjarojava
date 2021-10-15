package com.company;

import java.util.ArrayList;
import java.util.List;

public class FindSubsequences491_2 {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> min = new ArrayList<>();
    private int ll;
    public List<List<Integer>> findSubsequences(int [] nums){
        ll = nums.length;
        dfs(nums,0,Integer.MIN_VALUE);
        return ans;


    }


    // 2 的 n次方  如何剪枝呢
    public void dfs(int[] nums,int cur, int last){
        if(cur == ll){
            if(min.size() >= 2){
                ans.add(new ArrayList<>(min));
            }
            return;
        }


        // if  nums[cur] >= last 当然可以加进去
        if (nums[cur] >= last) {


            min.add(nums[cur]);
            dfs(nums,cur+1,nums[cur]);
            // 只是为了回溯
            min.remove(min.size()-1);
        }

        // 剪枝  if nums[cur] == last 不递归结束了
            if(nums[cur] != last)
                //  if nums[cur] != last  递归 但是不加入当前元素
            dfs(nums,cur+1,last);



    }



    public static void main(String[] args) {
        System.out.println(new FindSubsequences491_2().findSubsequences(new int[]{1,2,1,1}));
    }
}
