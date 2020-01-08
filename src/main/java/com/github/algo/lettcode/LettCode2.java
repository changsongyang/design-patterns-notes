package com.github.algo.lettcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class LettCode2 {

    public static void main(String[] args) {

    }

    /**
     *  主要考虑进位  遍历两个链表 把他们的值想加 如果大于等于10 进进位+1
     *   用一个新的虚拟节点来保存新加的值
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dump=new ListNode(-1);
        ListNode cur=dump;
        int sum=0;
        while (l1!=null || l2 !=null || sum>0){
            int a=l1==null?0:l1.val;
            int b=l2==null?0:l2.val;
            sum+=a+b;
            cur.next=new ListNode(sum % 10);
            cur=cur.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }

            sum /=10;
        }
        return  dump.next;
    }
     public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
