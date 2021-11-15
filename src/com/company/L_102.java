package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L_102 {
    public List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        if (root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode<Integer>> queue = new LinkedList<>();
        TreeNode<Integer> now,last = root;

        queue.addLast(root);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        while (queue.size() > 0){
            now = queue.pollFirst();
            ans.get(ans.size()-1).add(now.val);
            if (now.left != null){
                queue.addLast(now.left);
            }
            if (now.right != null){
                queue.addLast(now.right);
            }

            if (last == now){
                last = queue.peekLast();
                if (last == null)break;
                ans.add(new ArrayList<>());
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        Trees<Integer> trees = new Trees<>();
        TreeNode<Integer> integerTreeNode = trees.array2tree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(new L_102().levelOrder(integerTreeNode));

    }
}
