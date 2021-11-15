package com.company;

import java.util.Vector;

public class L_337 {
    int[] none = new int[]{0,0};
    public int rob(TreeNode<Integer> root) {
        int[]r = dfs(root);
        return Math.max(r[0],r[1]);
    }

    public int[] dfs(TreeNode<Integer> root){
        if(root == null)return none;
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        return new int[]{ root.val+l[1] + r[1], Math.max(l[0],l[1]) + Math.max(r[0],r[1])};

    }
}
