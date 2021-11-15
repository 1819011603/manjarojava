package com.company;

import java.util.List;

public class O_24 {

    ListNode pre = null;
    public ListNode reverseList(ListNode head) {
        if(head == null)return null;
        dfs(head);
        head.next = null;
        return pre;

    }

    public ListNode dfs(ListNode head){
        if(head == null)return null;
        ListNode next = dfs(head.next);
        if(next != null){
            next.next = head;
        }else{
            pre = head;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1),cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);
        cur = cur.next;
        cur.next = null;
        System.out.println(new O_24().reverseList(head));


    }
}
