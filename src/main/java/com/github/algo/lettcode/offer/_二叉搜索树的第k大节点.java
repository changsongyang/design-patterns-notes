package com.github.algo.lettcode.offer;


import java.util.ArrayList;
import java.util.List;

/**
 给定一棵二叉搜索树，请找出其中第k大的节点。
 示例 1:

 输入: root = [3,1,4,null,2], k = 1
 3
 / \
 1   4
 \
    2
 输出: 4
 示例 2:

 输入: root = [5,3,6,2,4,null,null,1], k = 3
 5
 / \
 3   6
 / \
 2   4
 /
 1
 输出: 4
  

 限制：

 1 ≤ k ≤ 二叉搜索树元素个数

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _二叉搜索树的第k大节点 {


    public int kthLargest(TreeNode root, int k) {
        // 求二插搜索树的第K大节点， 中序遍历后的顺序是有序，保存在一个集中中，
        /// 然后list.size()-k 就是第K大
        List<Integer> data= getList(root,new ArrayList<>());
        return  data.get(data.size()-k);
    }

    private List<Integer>  getList(TreeNode root,List<Integer> list){
        // 递归终止条件
        if(root==null) return  list;

        //左子树
        getList(root.left,list);
        list.add(root.val);
        getList(root.right,list);
        return  list;
    }
}
