package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L_368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> temp = new ArrayList<>();
        int m = 1;
        int m_j = 0;
        for (int i = 0;i < nums.length; i++){
            ArrayList<Integer> objects = new ArrayList<>();
            objects.add(nums[i]);
            temp.add(objects);
            int max = 1;
            int max_j = i;
            List<Integer> list = null;
            for (int j = i-1; j >= 0; j--){
                if (nums[i] % nums[j] == 0){
                   list = temp.get(j);
                    if (max < list.size()){
                        max = list.size();
                        max_j = j;
                    }

                }


            }
            if (max_j != i){
                objects.addAll(temp.get(max_j));
                if (m < objects.size()){
                    m = objects.size();
                    m_j = i;
                }
            }
        }

        return temp.get(m_j);

    }
}
