package com.github.algo.lettcode.offer;



/**
 面试题06. 从尾到头打印链表
 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 示例 1：

 输入：head = [1,3,2]
 输出：[2,3,1]

 限制：
 0 <= 链表长度 <= 10000
 */
public class _从尾到头打印链表 {

    /**
     * 解法一： 先求出链表的长度 构造一个数组， 然后在遍历链表  最前面的元素放在数组尾部
     * 解法二： 利用栈先进后出的特性，把链表元素遍历到栈中， 然后在根据栈的长度构造一个数组，遍历整个栈到数组中
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        // 求出链表的长度
        int len=0;
        ListNode temp=head;
        while (temp!=null){
            temp=temp.next;
            len++;
        }
        int [] arr=new int[len];
        // 遍历链表 前面的保存到数组尾部
        ListNode cur=head;
        while (cur!=null){
            arr[--len]=cur.val;
            cur=cur.next;
        }
        return  arr;
    }
}
