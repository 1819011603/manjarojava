package com.company;

public class L_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums,0,nums.length-1);
    }

    public TreeNode dfs(int[] nums,int l,int r){
        if (l > r)return null;
        int max = Integer.MIN_VALUE;
        int max_j = -1;
        for (int i = l; i <= r; i++){
            if (nums[i] > max){
                max = nums[i];
                max_j = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = dfs(nums,l,max_j-1);
        root.right = dfs(nums,max_j+1,r);
        return root;
    }
}
