package com.github.algo.lettcode;


/**
 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

 你应当保留两个分区中每个节点的初始相对位置。

 示例:

 输入: head = 1->4->3->2->5->2, x = 3
 输出: 1->2->2->4->3->5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/partition-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LettCode86 {
    public static void main(String[] args) {

    }


    /**
     *  利用两个辅助节点low high
     *  遍历head链表  小于x 放入low链表中  大于等于x 放入high 链表中
     *  最后low.next=high  合并成一个链表就over了
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode low=new ListNode(-1);
        ListNode lowCur=low;
        ListNode high=new ListNode(-1);
        ListNode highCur=high;
        while (head!=null){
            if(head.val < x){
                lowCur.next=head;
                lowCur=lowCur.next;
            }else{
                highCur.next=head;
                highCur=highCur.next;
            }
            head=head.next;
        }
        // 小链表的尾节点指向大链表头节点的下个节点
        lowCur.next=high.next;
        // 大链表的尾节点置换为空
        highCur.next=null;
        return  low.next;
    }
}
