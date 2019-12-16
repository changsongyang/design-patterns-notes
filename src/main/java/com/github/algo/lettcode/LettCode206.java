package com.github.algo.lettcode;

public class LettCode206 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        // 翻转 及将所有的节点的next指向前面的节点
        // 所以要用一个临时变量保存当前前面节点
        ListNode cur=head;
        ListNode pre=null;
        while(cur!=null){
            // 保存当前节点的下一个节点
            ListNode next=cur.next; //  第一次为 2
            // 把当前节点的next变为前面的节点
            cur.next=pre;  // 此时 1->pre->null .....   后面断档了
            pre=cur;    // 1->1
            cur=next;  // 2->1
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        reverseList(head);
    }
}


