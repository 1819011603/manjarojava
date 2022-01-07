package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class O_36 {

    TreeNode head = null,tail = null,pre;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null)return null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while(!stack.isEmpty() ||  cur!=null){
            if(cur!= null){
                stack.addLast(cur);

                cur = cur.left;
            }else{
                cur = stack.pollLast();



                if(head== null){
                    head = cur;
                }
                tail = cur;

                    cur = cur.right;



            }
        }

        head.left = tail;
        tail.right = head;
        return head;
    }

    public static void main(String[] args) {
        Trees<Integer> trees = new Trees<>();
        TreeNode<Integer> integerTreeNode = trees.array2tree(new Integer[]{4, 2, 5, 1, 3});
        new O_36().treeToDoublyList(integerTreeNode);
    }
}
