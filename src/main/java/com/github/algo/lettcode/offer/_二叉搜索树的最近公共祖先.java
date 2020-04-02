package com.github.algo.lettcode.offer;



/**
 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _二叉搜索树的最近公共祖先 {


    /**
     * 最近公共祖先：
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return  null;

        if(p.val < root.val && q.val<root.val){
            // 左递归
           return lowestCommonAncestor(root.left,p,q);
        }

        if(p.val > root.val && q.val>root.val){
            // 右递归
           return lowestCommonAncestor(root.right,p,q);
        }

        // 如果p,q在左右都有 则返回根节点
        return  root;

    }
}
