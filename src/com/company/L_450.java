package com.company;

public class L_450 {
    public TreeNode deleteNode(TreeNode<Integer> root, int key) {
        if(root == null)return null;
        if(root.val > key){
            root.left = deleteNode(root.left,key);
            return root;
        }else if( root.val < key){
            root.right = deleteNode(root.right,key);
            return root;
        }else{
            if(root.left != null){
                TreeNode<Integer> cur = root.left;
                while(cur.right != null){
                    cur = cur.right;
                }
                root.val = cur.val;
                root.left = deleteNode(root.left,cur.val);
                return root;

            }else return root.right;
        }

    }

    public static void main(String[] args) {
        Trees<Integer> trees = new Trees<>();
        TreeNode<Integer> integerTreeNode = trees.array2tree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        System.out.println(new L_450().deleteNode(integerTreeNode,3));
    }
}
