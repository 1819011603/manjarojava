package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class L_2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null)return new int[]{-1,-1};
        List<Integer> cur = new ArrayList<>();
        while (head != null){
            cur.add(head.val);
            head = head.next;
        }
        int size = cur.size()-1;
        Integer[] list = new Integer[cur.size()];
        cur.toArray(list);

        int min = Integer.MAX_VALUE;
        int pre = -1000000;
        int first = -1;
        for(int i = 1; i < size; i++){
            if (list[i]<list[i-1]){
                if (list[i] < list[i+1]){
                    if (first == -1){
                        first = i;
                    }
                    min = Math.min(min,i-pre);
                    pre = i;

                }
                continue;
            }

            if (list[i]>list[i-1]){
                if (list[i] > list[i+1]){
                    if (first == -1){
                        first = i;
                    }
                    min = Math.min(min,i-pre);
                    pre = i;

                }
            }
        }
        if (first == -1 || pre == first)return new int[]{-1,-1};
        int max = pre -first;
        return new int[]{min,max};
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        System.out.println(Arrays.toString(new L_2058().nodesBetweenCriticalPoints(head)));
    }
}
