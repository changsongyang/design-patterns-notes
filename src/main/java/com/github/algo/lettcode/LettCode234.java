package com.github.algo.lettcode;

import java.util.ArrayList;
import java.util.List;

/**
 请判断一个链表是否为回文链表。

 示例 1:

 输入: 1->2
 输出: false
 示例 2:

 输入: 1->2->2->1
 输出: true
 进阶：
 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class LettCode234 {

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(1);
        head.next.next.next.next=null;
        System.out.println(isPalindrome(head));

    }

    /**
     * 使用双指针法： 先把链表遍历保存到一个数组中， 然后使用首尾两个
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode cur=head;
        while (cur!=null) {
            list.add(cur.val);
            cur = cur.next;

        }

        int first=0;
        int tail=list.size()-1;
        while (first < tail){
            if(!list.get(first).equals(list.get(tail))){
                return  false;
            }
            first++;
            tail--;
        }
        return  true;
    }
}
