package com.github.algo.lettcode;

/**
 删除链表中等于给定值 val 的所有节点。

 示例:

 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 */


public class LettCode203 {
    public static void main(String[] args) {

    }


    public ListNode removeElements(ListNode head, int val) {
        //  可能会改变头节点  所以要使用辅助节点
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while(cur!=null && cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
