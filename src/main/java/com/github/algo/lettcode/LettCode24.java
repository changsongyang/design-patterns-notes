package com.github.algo.lettcode;


/**
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

  

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LettCode24 {

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=null;

        swapPairs(head);

    }

    /**
     * 定义一个虚拟节点 ListNode dummy=new ListNode(-1)
     * 定时当前节点   dummy.next=head;  ListNode cur=dummy;
     * 利用三个指针a,b,c   a=cur.next  b=a.next= c=b.next  首先遍历中定位到三个指针的位置
     * 然后执行交换  首先当前节点的next指向 cur.next=b  然后a.next=c ,b.next=a 最后移动cur=a
     * 比如 初始节点时 1->2->3->4  虚拟节点 -1->1->2->3->4
     *  第一轮:   cur.next=b -1->2->3->4    a.next=c  1->3>4  b.next=a -1->2->1->3>4  cur=a cur=2;
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;
        while (cur.next!=null && cur.next.next!=null){
            // 找到 a,b,c三个指针的位置
            ListNode a=cur.next;
            ListNode b=a.next;
            ListNode c= b.next;
            // 开始交换
            cur.next=b;
            a.next=c;
            b.next=a;
            cur=a;
        }
        return  dummy.next;
    }
}
