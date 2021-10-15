package com.company;

public class L_98 {
    public boolean isValidBST(TreeNode<Integer> root) {
        return dfs(root);
    }

    TreeNode<Integer> pre = null;
    public boolean dfs(TreeNode<Integer> root){
        if (root == null)return true;
        boolean lCheck = dfs(root.left);
        if (!lCheck)return false;

        if(pre != null && pre.val >= root.val){
            return false;
        }
        pre  = root;
        return dfs(root.right);
    }

    public static void main(String[] args) {
        Trees<Integer> trees = new Trees<>();
        trees.array2tree(new Integer[]{
                5,1,4,null,null,3,6
        });
        System.out.println(new L_98().isValidBST(trees.getRoot()));
    }

}
