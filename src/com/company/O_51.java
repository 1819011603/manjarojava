package com.company;

import javafx.beans.binding.StringExpression;
import sun.text.normalizer.UBiDiProps;

public class O_51 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode<Integer> root) {
        dfs(root);
        return ans;
    }


    public int dfs(TreeNode<Integer> root){
        if (root == null)return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = left+right+root.val;
        ans = Math.max(ans,sum);
        return Math.max(root.val+Math.max(left,right),0);
    }



    public static void main(String[] args) {
        Trees<Integer> trees = new Trees<>();
        TreeNode<Integer> integerTreeNode = trees.array2tree(new Integer[]{2,-1});

        System.out.println(new O_51().maxPathSum(integerTreeNode));
    }
}
