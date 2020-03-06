package com.github.algo.lettcode;


/**
 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

 示例 1:
 inStack
 输入: 1->1->2
 输出: 1->2
 示例 2:

 输入: 1->1->2->3->3
 输出: 1->2->3

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LettCode83 {

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(1);
        head.next.next=new ListNode(2);
        head.next.next.next=null;

        ListNode newNode=deleteDuplicates(head);
        while (newNode!=null){
            System.out.println(newNode.val);
            newNode=newNode.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur=head;
        while(cur!=null && cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return head;
    }
}
