package com.github.algo.lettcode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * @author qinxuewu
 * @create 20/1/24下午1:14
 * @since 1.0.0
 */


public class LettCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p=headA;
        ListNode q=headB;
        while(p!=q){
            if(p!=null){
                p=p.next;
            }else{
                p=headB;
            }

            if(q!=null){
                q=q.next;
            }else{
                q=headA;
            }
        }

        return p;
    }
}
