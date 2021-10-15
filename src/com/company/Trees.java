package com.company;

import java.util.*;

public class Trees<T extends Comparable<T>> {
    private TreeNode<T> root;

    // leetcode Integer数组建树
    public  TreeNode<T>  array2tree(T[] objects){
        if(root != null)root = null;
        if (objects == null || objects.length == 0 || objects[0] == null)return null;
        arrayToTree(objects);
        return root;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void preOrder(TreeNode<T> cur){

        Stack<TreeNode<T>> s = new Stack<>();
        while(cur != null || !s.empty()){
            if(cur != null) {
                System.out.print(cur.getVal() + " ");
                s.push(cur);
                cur = cur.left;
            }else {
                cur = s.pop();
                cur = cur.right;
            }
        }
        System.out.println();

    }
    public void inOrder(TreeNode<T> cur){

        Stack<TreeNode<T>> stack = new Stack<>();

        while (cur != null || !stack.empty()){
            if( cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }else {
                cur = stack.pop();
                System.out.print(cur.getVal() + " ");
                cur = cur.getRight();

            }
        }
        System.out.println();
    }
    public void behindOrder(TreeNode<T> cur){
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> pre = null;
        while (!stack.empty() ||  cur!=null){
            if(cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }else{
                cur = stack.peek();
                if(cur.getRight() != null && cur.getRight()!=pre){
                    cur = cur.getRight();
                }else {
                    stack.pop();
                    System.out.print(cur.getVal() + " ");
                    pre = cur;
                    cur =null;

                }
            }
        }
        System.out.println();
    }
    public String preOrderOnly(){
        return preOrderOnly(this.root);

    }
    // 唯一确定一棵树的前序遍历
    public String preOrderOnly(TreeNode<T> root){
        StringBuilder s = new StringBuilder();
        preOnly(root,s);
        return new String(s);

    }
    private void preOnly(TreeNode<T> root,StringBuilder s){
        if(root == null){
            s.append("_#");
            return;
        }
        s.append("_").append(root.val);
        preOnly(root.left,s);
        preOnly(root.right,s);
    }

    public void arrayToTree(T[] objects){
        LinkedList<TreeNode<T>> list = new LinkedList<>();
        int i = 1,j,k;

        root = new TreeNode<>(objects[0]);
        list.push(root);
        TreeNode<T> t;
        // leetcode 中的Tree是每一个父节点都有两个孩子  所有节点总和（包括null孩子）也就是数组长度肯定是奇数
        // 如果当前节点的索引值为奇数，则表明该节点为左孩子   如果当前节点的索引值为偶数，则表明该节点为右孩子
        while ( i < objects.length && list.size() != 0){
            // t为需要插入左右节点的父节点
            t = list.poll();
            // 看当前这个节点有没有空节点  j保存当前i的值  i向后遍历null值
            j = i;
            while (i < objects.length && objects[i] == null){
                i++;
            }
            // k 为  (j,i)之间的null值
            k = (i-j)>>1;
            while (k-- != 0){
                t = list.poll(); // 换下一个父节点
            }
            if (t == null){ // [1,null,null] 可以  leetcode中是不用加这句话  它会保证输入合法
                break;
            }
            if(i % 2 == 1){ // 如果当前节点的索引值为奇数，则表明该节点为左孩子
                if(i < objects.length){ // 可以为左孩子
                    t.setLeft(new TreeNode<>(objects[i++])); // 设为左孩子
                    list.addLast(t.getLeft()); // 加入队列
                }

                // 右孩子存在且不为null 设为右孩子 加入队列
                if(i < objects.length && objects[i] != null){
                    t.setRight(new TreeNode<>(objects[i++]));
                    list.addLast(t.getRight());
                }else i++;  // 1.右孩子存在且为null i++ 插入下一个元素 2.右孩子不存在(i>= objects.length) i++也可以退出循环

            }else {// 如果当前节点的索引值为偶数，则表明该节点为右孩子  右孩子存在的话肯定不为null（前面的while） 设为右孩子 加入队列
                if(i < objects.length){
                    t.setRight(new TreeNode<>( objects[i++]));
                    list.addLast(t.getRight());
                }
                // 将队列中的下一个不为null的节点 插入其左右孩子

            }

        }

    }
}