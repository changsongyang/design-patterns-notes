package com.github.algo.lettcode;

/**
 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

 现有一个链表 -- head = [4,5,1,9]，它可以表示为:


 示例 1:

 输入: head = [4,5,1,9], node = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 示例 2:


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class LettCode237 {

    public void deleteNode(ListNode node) {
        //  脑筋急转弯题目， 一般删除指定节点 是要找到上一个节点，但是此题只给了要删除节点
        // 所以做法就是直接把当前节的下一个结点赋值给当前节点，这样然后改变当前的节点的指向 其实就达到删除的目的
        node.val=node.next.val;
        node.next=node.next.next;

    }
}
