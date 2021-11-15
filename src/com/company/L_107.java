package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)return ans;
        Deque<TreeNode> deque = new LinkedList<>(),d = new LinkedList<>(),tmp;
        deque.addLast(root);

        while (deque.size() > 0){
            List<Integer> list = new ArrayList<>();
          while (deque.size() > 0){
              TreeNode<Integer> cur = deque.pollFirst();
              list.add(cur.val);
              if (cur.left!=null){
                  d.addLast(cur.left);
              }
              if (cur.right != null){
                  d.addLast(cur.right);
              }

          }
          ans.add(0,list);
            tmp = d;
            d = deque;
            deque = tmp;

        }
        return ans;

    }
    public static void main(String[] args) {

    }
}
