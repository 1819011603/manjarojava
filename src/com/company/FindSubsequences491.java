package com.company;

import java.util.*;

public class FindSubsequences491 {

    public void get(Set<List<Integer>> set,int[] nums, int l, int len,List<Integer> list){
        if (len == list.size()){
            set.add(new ArrayList<>(list));
            return;
        }
        for(int i = l; i < nums.length; i++){
            list.add(nums[i]);
            get(set,nums,i+1,len,list);
            list.remove(list.size()-1);
        }

    }

    public List<List<Integer>> findSubsequences(int [] nums){

        int ll = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        while (ll >=2){
            get(set,nums,0,ll,new ArrayList<>());
            ll--;
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (List<Integer> list: set){
            if(isValid(list)){
                lists.add(list);
            }
        }

        return lists;
    }

    private boolean isValid(List<Integer> list) {
        for (int i = 1; i < list.size(); i++){
            if(list.get(i) < list.get(i-1))return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new FindSubsequences491().findSubsequences(new int[]{1,2,3,1,1}));
    }
}
