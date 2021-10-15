package com.company;

import java.util.HashMap;
import java.util.TreeMap;

public class L_437 {
    int ans = 0;
    int sum = 0;
    public void preOrder(TreeNode<Integer> root,int targetSum){
        if(root != null){

            dfs(root,targetSum);
            preOrder(root.left,targetSum);
            preOrder(root.right,targetSum);
        }
    }
    public int pathSum1(TreeNode<Integer> root, int targetSum) {
        ans = 0;
        preOrder(root,targetSum);
        return ans;
    }

    public void dfs(TreeNode<Integer> root, int targetSum){
        if(root == null)return;

        sum+= root.val;

        if(sum == targetSum){
            ans++;
        }

        dfs(root.left,targetSum);

        dfs(root.right,targetSum);

        sum-= root.val;


    }
    public int pathSum(TreeNode<Integer> root, int targetSum) {
        ans = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        dfs1(root,targetSum,0,prefixSum);
        return ans;
    }
    public void dfs1(TreeNode<Integer> root, int targetSum,int sum,HashMap<Integer, Integer> prefixSum){
        if (root == null)return;
        sum+= root.val;
        ans+= prefixSum.getOrDefault(sum-targetSum,0);
        prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);
        dfs1(root.left,targetSum,sum,prefixSum);
        dfs1(root.right,targetSum,sum,prefixSum);
        prefixSum.put(sum,prefixSum.get(sum)-1);
    }


    public static void main(String[] args) {
        Trees<Integer> trees = new Trees<>();
        TreeNode<Integer> root = trees.array2tree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});



        System.out.println(new L_437().pathSum(root,8));
//        System.out.println(new L_437().pathSum(root,8));

    }
}
