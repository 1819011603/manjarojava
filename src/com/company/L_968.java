package com.company;

public class L_968 {
    public int minCameraCover(TreeNode root) {
        int[] r = dfs(root);
        return Math.min(r[0],r[1]);
    }
    int[] n = new int[]{0,0};
    public int[] dfs(TreeNode root){
        if(root == null)return n;
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int min = l[0] + r[1];
        int min1 = l[1] + r[0];

        return new int[]{Math.min(Math.min(min,min1),l[1]+r[1]) , Math.min(Math.min(min,min1),l[0]+r[0])+1};
    }

    public static void main(String[] args) {
        Trees<Integer> trees = new Trees<>();
        TreeNode<Integer> integerTreeNode = trees.array2tree(new Integer[]{0, 0, null, 0, null, 0, null, null, 0});
        System.out.println(new L_968().minCameraCover(integerTreeNode));
    }
}
