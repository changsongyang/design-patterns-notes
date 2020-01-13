package com.github.algo.lettcode;


/**
 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

 示例:

 输入:
 [
   1->4->5,
   1->3->4,
   2->6
 ]
 输出: 1->1->2->3->4->4->5->6

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LettCode23 {
    public static void main(String[] args) {
        
    }

    /**
     * 使用分治的思想 两两合并, 这样每轮两两合并就是有序了  不断分治合并
     *  从数组链表中的第一个和最后开始合并(n,n-1-i)， 不断合并知道每轮分区汇总只剩下0或一个。 最后返回第个节点就是合并后有序
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // 当前数组的长度
        int len=lists.length;
        if (len==0){
                return null;
        }
        // 开始分区合并  以中间点开始
        while (len>1) {
            for (int i = 0; i < len / 2; i++) {
                // 分治 两两合并
                lists[i] = mergeTwoNode(lists[i], lists[len - 1 - i]);
            }
            // 更新中间点
            len = (len + 1) / 2;
        }
        return  lists[0];
    }


    public  ListNode mergeTwoNode(ListNode l1,ListNode l2){
            ListNode dummy=new ListNode(-1);
            ListNode cur=dummy;
            while (l1!=null || l2!=null){
                if(l1.val<=l2.val){
                    cur.next=l1;
                    l1=l1.next;
                }else{
                    cur.next=l2;
                    l2=l2.next;
                }
                cur=cur.next;
            }
            if(l1==null){
                cur.next=l2;
            }
            if(l2==null){
                cur.next=l1;
            }
            return  dummy.next;
    }
}
