package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L_199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>(),d = new LinkedList<>(),tmp;
        deque.addLast(root);
        while (deque.size() > 0){

            TreeNode<Integer> treeNode = deque.peekLast();
            ans.add(treeNode.val);
            while (deque.size() > 0){
                treeNode = deque.pollFirst();
                if (treeNode.left!=null){
                    d.addLast(treeNode.left);
                }
                if (treeNode.right != null){
                    d.addLast(treeNode.right);
                }
            }
            tmp = d;
            d = deque;
            deque = tmp;

    }
        return ans;
}

}
