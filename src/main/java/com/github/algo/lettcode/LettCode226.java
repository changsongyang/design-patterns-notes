package com.github.algo.lettcode;
import java.util.LinkedList;
import java.util.Queue;

/**
 226. 翻转二叉树
 翻转一棵二叉树。

 示例：

 输入：

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 输出：

 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 */


public class LettCode226 {

    // 使用递归前序遍历 二叉树

    /**
     * 使用二叉树的前序 后遍历 层序遍历 都可以实现反转， 中序遍历翻转时要注意交换后继续遍历left
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        // 前序遍历
        if(root==null){ return  root ;}

        // 开始交换左右节点
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        invertTree(root.left);
        invertTree(root.right);

        return  root;
    }


    public TreeNode invertTree2(TreeNode root) {
        if(root==null){
            return  root;
        }

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();

            // 开始交换左右节点
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;

            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return  root;
    }
}
