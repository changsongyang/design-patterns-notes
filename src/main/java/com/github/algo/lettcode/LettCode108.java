package com.github.algo.lettcode;

/**
 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

 示例:

 给定有序数组: [-10,-3,0,5,9],

 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

 0
 / \
 -3   9
 /   /
 -10  5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class LettCode108{


    /**
     *  https://leetcode.wang/leetCode-3-Longest-Substring-Without-Repeating-Characters.html
     *
     *
     *  二叉搜索树的中序遍历刚好可以输出一个升序数组
     * 有序数组转二叉树，可以使用递归+二分查找法寻找每次的每根节点
     *  二叉树左子节点的值小于等于它的根节点，右节点的值大于等于它的根节点
     *
     *  找到了根节点，然后把数组一分为二，进入递归即可。注意这里的边界情况，包括左边界，不包括右边界。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return  budile(nums,0,nums.length);
    }


    private  TreeNode budile(int []arr ,int l, int r){
        /// 递归终止条件
        if(l == r){ return  null;}
        //  找到数组分割点
        int mid=(l+r) >>> 1;
        // 构造一个根节点
        TreeNode root=new TreeNode(arr[mid]);
        // 左边递归
        root.left=budile(arr,l,r);
        root.right=budile(arr,mid+1,r);
        return  root;
    }
}
