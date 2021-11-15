package com.company;

import java.util.*;

public class L_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>(),d = new LinkedList<>(),tmp;
        int l = 0;
        deque.addLast(root);
        while (deque.size() > 0){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i<size; i++){
                TreeNode<Integer> cur = deque.pollFirst();
                list.add(cur.val);
                if (l == 1){
                    if (cur.right != null){
                    d.addFirst(cur.right);
                }
                    if (cur.left!= null){
                        d.addFirst(cur.left);
                    }

                }else {

                    if (cur.left!= null){
                        d.addFirst(cur.left);
                    }
                    if (cur.right != null){
                        d.addFirst(cur.right);
                    }

                }
            }
            l=1-l;
            ans.add(list);
            tmp = deque;
            deque = d;
            d = tmp;
        }
       return ans;
    }
    public static void main(String[] args) {
        Trees<Integer> trees = new Trees<>();
        TreeNode<Integer> integerTreeNode = trees.array2tree(new Integer[]{1,2,3,4,null,null,5});
        System.out.println(new L_103().zigzagLevelOrder(integerTreeNode));
    }
}
