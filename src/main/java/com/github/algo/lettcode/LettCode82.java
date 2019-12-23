package com.github.algo.lettcode;


/**
 * 功能描述:  给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 示例 1:

         输入: 1->2->3->3->4->4->5
         输出: 1->2->5
 示例 2:

         输入: 1->1->1->2->3
         输出: 2->3
 */
public class LettCode82 {

    public static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
   }

    public  static ListNode deleteDuplicates(ListNode head) {


        return  null;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(4);
        head.next.next.next.next.next=new ListNode(4);
        head.next.next.next.next.next.next=new ListNode(5);
        deleteDuplicates(head);

        ListNode cur=head;
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
}
