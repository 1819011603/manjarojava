package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L_894 {

    HashMap<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if((n & 1) == 0){
            return new ArrayList<>();
        }

        List<TreeNode> one= new ArrayList<>();
        one.add(new TreeNode(0));
        map.put(1,one);

        return dfs(n);

    }

    public List<TreeNode> dfs(int n){
       if (map.containsKey(n)){
            return  map.get(n);
        }else{
           List<TreeNode> t = new ArrayList<>();
           map.put(n,t);
            for (int i = 1; i <= n-2; i+=2){

                List<TreeNode> dfs = dfs(i);
                List<TreeNode> dfs1 = dfs(n - i - 1);
                for (TreeNode d:dfs){
                    for (TreeNode d1:dfs1){
                        TreeNode r = new TreeNode(0);
                        r.left = d;
                        r.right = d1;
                        t.add(r);
                    }
                }
            }
            return t;
        }
    }

    public static void main(String[] args) {
        System.out.println(new L_894().allPossibleFBT(7));
    }
}
