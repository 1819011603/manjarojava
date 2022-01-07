package com.company;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public  static  ListNode arrayToList(Integer[] integers){
        if(integers.length == 0)return  null;
        ListNode head = new ListNode(integers[0]);
        ListNode cur = head;
        for(int i = 1; i < integers.length; i++){
            cur.next = new ListNode(integers[i]);
            cur = cur.next;
        }
        return  head;
    }
}
