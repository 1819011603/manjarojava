package com.company;

import java.util.List;

public class L_143 {

    public void reorderList(ListNode head) {
        dfs(head,head);
    }
    public ListNode[] dfs(ListNode slow, ListNode quick){
        if(quick == null || quick.next == null){
            if(quick == null){ // 0　偶数长度

                return new ListNode[]{slow,null};
            }

            else{ // 1 　奇数长度 　思路是从中间往前去加　
                ListNode n = slow.next;
                slow.next = null; // 中间节点.next == null;
                return new ListNode[]{n,slow};
            }
        }

        ListNode[] l = dfs(slow.next,quick.next.next);//  l[0] 为slow 节点的下一个节点　l[1]为l[0]的下一个节点　　slow -> l[0] -> l[1]

        ListNode n = l[0].next; // n 为 要插入的下一个节点
        slow.next = l[0];
        l[0].next = l[1]; // slow -> l[0] -> l[1]

        return new ListNode[]{n,slow}; //下一次遍历　　 slow.pre -> l[0].next -> slow



    }

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode cur = a;
        a.next = new ListNode(2);
        a = a.next;
        a.next = new ListNode(3);
        a = a.next;
        a.next = new ListNode(4);
        a = a.next;
        a.next = new ListNode(5);
        a = a.next;
        new L_143().reorderList(cur);
        System.out.println(cur);
    }
}
