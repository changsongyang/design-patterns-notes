package com.github.algo.lettcode;

/**
 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: 1->2->3->4->5->NULL, k = 2
 输出: 4->5->1->2->3->NULL
 解释:
 向右旋转 1 步: 5->1->2->3->4->NULL
 向右旋转 2 步: 4->5->1->2->3->NULL

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/rotate-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LettCode61 {

    public static void main(String[] args) {
        
    }

    /**
     *  思路： 这道题的意思就是从倒数第K个节点开发反转，和删除倒数第K个节点类
     *     先求出链表的长度，
     *     然后 k = k % len取余就是我们要右移的距离。
     *     找到第K个节点的 使用双指法， 快指针先走K步  然后快慢指针一起走， 此时慢指针指向的位置就是分割点(next指向要翻转的部分)
     *    然后把分割节点开右边的节点，翻转到分割点前半段前面即可
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0){
            return head;
        }
        ListNode temp=head;
        // 求出链表长度
        int len=0;
        while (temp!=null){
            len++;
            temp=temp.next;
        }
        //需要右移的举例
        k= k % len;
        if(k==0){
            return  head;
        }
        // 定义快慢指针
        ListNode first=head;
        ListNode slow=head;
        while (k>0){
            k--;
            first=first.next;
        }
        while (first.next!=null){
            first=first.next;
            slow=slow.next;
        }

        // 分割点开始的节点翻转

        first.next=head;   // 尾节点的next指向原先头节点
        head=slow.next;  // 分割节点的下一个节点变成新的头节点
        slow.next=null;    // 分割节点指向null  断掉环
        return head;
    }
}
