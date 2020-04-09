package com.github.algo.lettcode.offer;



/**
 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _二叉树的最近公共祖先2 {

    /**
     * 递归解法： 递归遍历查找p,q节点
     * 如果 右子树找不到p,q 那么说明p,q都在左子树
     *  如果 左子树找不到p,q 那么说明p,q都在右子树
     *  如果 不符合以上条件 则说明 p 和 q 分别在左子树和右子树，那么当前节点为最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==root || q==root)  return  root;

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(right==null)  return  left;
        if(left==null) return  right;
        return  root;
    }
}
