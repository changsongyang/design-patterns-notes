package com.github.algo.lettcode;


/**
 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LettCode19 {

    public static void main(String[] args) {

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        //  利用快慢指针， 快指针先走n+1次  然后快慢指针同时走，当快指针走到节点尾部时  慢指针就走到了倒数n节点的位置的前一个节点

        // 创建一个虚拟节点 防止头节点改变
        ListNode dumm=new ListNode(-1);
        dumm.next=head;
        // 定义两个指针 快慢指针
        ListNode first=dumm;
        ListNode low=dumm;

        for (int i = 0; i < n+1; i++) {
            first=first.next;
        }
        while (first!=null){
            first=first.next;
            low=low.next;
        }
        low.next=low.next.next;
        return  dumm.next;


    }
}
