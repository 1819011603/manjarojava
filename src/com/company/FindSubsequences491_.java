package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubsequences491_ {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> min = new ArrayList<>();
    private int ll;
    public List<List<Integer>> findSubsequences(int [] nums){
        ll = nums.length;
        dfs(nums,0,Integer.MIN_VALUE);
        return ans;


    }

    public void dfs(int[] nums,int cur, int last){
        // 到结尾了 肯定要return了
        if(cur == ll){
//            满足这个条件
            if(min.size() >= 2){
                ans.add(new ArrayList<>(min));
            }
            return;
        }

        // 满足某个条件选择加入该元素
        if(nums[cur] >= last){
            min.add(nums[cur]);
            dfs(nums,cur+1,nums[cur]);
            min.remove(min.size()-1);
        }

        // 满足某个条件不选泽加入该元素  但还是为继续递归
        if(nums[cur] !=  last){
            dfs(nums,cur+1,last);
        }

        // 4 6 7 7
        // 4 6 7 直接加
        // 到第二个7的时候  7 >= 7  4 6 7 7 选中
        // 回溯  删除末尾的7
        // 第一个7的功能可以表示现在的最大值了 第二个7可以直接去掉了
    }



    public static void main(String[] args) {
        System.out.println(new FindSubsequences491_().findSubsequences(new int[]{1,2,1,3,3,1}));
    }
}
