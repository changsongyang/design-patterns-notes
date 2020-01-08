package com.github.algo.lettcode;


/**
 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LettCode21 {

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        l1.next.next.next=null;

        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);
        l2.next.next.next=null;


        ListNode newNode=mergeTwoLists(l1,l2);
        while (newNode!=null){
            System.out.println(newNode.val);
            newNode=newNode.next;
        }
    }

    /**
     * 利用虚拟头节点来保存合并后的链表  ListNode dumm  和cur节点
     *  同时遍历两个链表 while
     *  有两种种情况：
     *  当 l1.val <= l2.val  则  cur.next=l1 且 l1=l1.next
     *  当 l1.val > l2.val  则  cur.next=l2 且 l2=l2.next
     *   最后  cur=cur.next;
     *
     *   遍历结束后一方为空  则追加到另一方的后面
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumm=new  ListNode(-1);
        ListNode cur=dumm;
        while(l1 !=null && l2 !=null){
            if(l1.val <= l2.val){
                cur.next=l1;
                l1=l1.next;
            }else if (l1.val > l2.val){
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        //  遍历结束后一方为空  则追加到另一方的后面
        if(l1 ==null){ cur.next=l2;}
        if(l2==null){ cur.next=l1; }
        return  dumm.next;
    }
}
