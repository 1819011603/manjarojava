package com.company;

public class O_26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null)return false;
        return dfs(A,B);
    }

    public boolean dfs(TreeNode A, TreeNode B) {
        if(B == null){
            return true;
        }else if(A == null){

            return false;
        }
        else if( A.val == B.val){
            return isSubStructure(A.left,B.left) && isSubStructure(A.right,B.right);
        }else{
            return isSubStructure(A.left,B) ||  isSubStructure(A.right,B);
        }
    }

    public static void main(String[] args) {
        Trees<Integer> t1 = new Trees<>();
        Trees<Integer> t2 = new Trees<>();
        TreeNode<Integer> integerTreeNode = t1.array2tree(new Integer[]{1, 2, 3, 4});
        TreeNode<Integer> integerTreeNode1 = t2.array2tree(new Integer[]{3});
        System.out.println(new O_26().dfs(integerTreeNode,integerTreeNode1));

    }
}
