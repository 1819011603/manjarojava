package com.company;

import java.util.ArrayList;
import java.util.List;

public class L_5894 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();
        int[] temp = new int[101];
        for (int j : nums1) {
            temp[j] = 1;
        }

        for (int j : nums2) {
            if (temp[j] == 1) {
                ans.add(j);
                temp[j] = -1;
            } else if (temp[j] == 0) {
                temp[j] = 2;
            }
        }
        for (int j : nums3) {
            if (temp[j] > 0) {
                ans.add(j);
                temp[j] = -1;
            }
        }
        return ans;
    }
}
