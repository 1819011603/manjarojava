package com.company;

import java.util.ArrayList;
import java.util.List;

public class FindSubsequences491_1 {
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
            if(min.size() >= 0){
                ans.add(new ArrayList<>(min));
            }
            return;
        }

            min.add(nums[cur]);
            dfs(nums,cur+1,nums[cur]);
            min.remove(min.size()-1);


            dfs(nums,cur+1,last);

            // 1 + 4 + 6 + 4 + 1 = 16  C44 + C34 + C24  + C14 + C04 = 16 == 2^4  组合


    }



    public static void main(String[] args) {
        System.out.println(new FindSubsequences491_1().findSubsequences(new int[]{1,2,3,4}));
    }
}
