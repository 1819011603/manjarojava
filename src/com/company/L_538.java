package com.company;

public class L_538 {
    public TreeNode<Integer> convertBST(TreeNode<Integer> root) {
        dfs(root);
        return root;

    }
    Integer pre = 0;
    public void dfs(TreeNode<Integer> root){
        if(root == null)return;
        dfs(root.right);
        root.val += pre;
        pre = root.val;
        dfs(root.left);


    }

}
