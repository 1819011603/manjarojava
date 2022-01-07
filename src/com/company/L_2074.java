package com.company;

public class L_2074 {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head == null)return head;
        head.next = helper(head.next,2,0);
        return head;
    }
    ListNode pre,next;
    int f = 0;

    public ListNode helper(ListNode head,int k,int m){
        if(head == null){
            if( m % 2 == 0){
                f = 2;

            }

            else f = 1;
            return null;
        }
        if(++ m == k){
            pre = head;
            if(k % 2 == 1 || 1== f)
                next = head;
            else next = head.next;
            return head;
        }
        ListNode n = helper(head.next,k,m);
        if(n== null){
            if(f == 2){

                pre = head;
                next = null;
            }else{
                pre = head;
                next =head;
            }
            return head;
        }

        if(f!=2 && (k % 2 == 1 || f == 1)){

            if(m == 1){

                next.next = helper(next.next,k+1,0);
            }

            return head;
        }else {


            if(m == 1){
                ListNode l = pre;

                head.next = helper(next,k+1,0);

                n.next = head;
                return l;

            }

            n.next = head;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.arrayToList(new Integer[]{5,2,6,3,4});
        System.out.println(new L_2074().reverseEvenLengthGroups(listNode));

    }
}
