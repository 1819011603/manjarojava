package com.company;

import java.util.ArrayList;
import java.util.List;

public class O_34 {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,0,target,new ArrayList<>());
        return  ans;
    }

    public TreeNode dfs(TreeNode<Integer> root,int sum, int target,List<Integer> cur){
        if(root == null)return null;
        sum+= root.val;
        cur.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == target){
                ans.add(new ArrayList<>(cur));
            }
        }


        dfs(root.left,sum,target,cur);
        dfs(root.right,sum,target,cur);
        cur.remove(cur.size()-1);
        return root;
    }
}
