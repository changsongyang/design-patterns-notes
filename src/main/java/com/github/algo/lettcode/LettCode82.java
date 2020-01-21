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

    /**
     * 删除链表中所有重复的元素 ，这题和删除链表重复的元素 只保存一个的变体
     *   需要一个虚拟头节点 和一个前指针辅助per，
     *   外层循环不断的遍历  内层循环比遍历判断cur.val=cur.next.val 相等移动cur节点的位置
     *   当per.next.next=cur 时 说明 cur只移动过一次 则 per=per.next 移动一位
     *   如果不相等则说明移动了多次 直接per.next=cur 即可 中间的元素就全删除了
     *  两重循环  当
     * @param head
     * @return
     */
    public  static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode per=dummy;
        ListNode cur=head;
        while (cur!=null){
            while (cur.next!=null && cur.val==cur.next.val){
                cur=cur.next;
            }
            cur=cur.next;

            if(per.next.next==cur){
                per=per.next;
            }else{
                per.next=cur;
            }
        }

        return  dummy.next;
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
