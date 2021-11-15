package com.company;

public class L_543 {

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;

    }
    static  int ans = 0;
    public static   int dfs(TreeNode root){
        if (root == null)return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans = Math.max(ans,l+r);
        return Math.max(l,r)+1;
    }

    public static void main(String[] args) {
        Trees<Integer> trees = new Trees<>();
        TreeNode<Integer> integerTreeNode = trees.array2tree(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(diameterOfBinaryTree(integerTreeNode));
    }
}
