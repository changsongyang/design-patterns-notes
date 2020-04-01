package com.github.algo.lettcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _从上到下打印二叉树2 {


    /**
     * 使用层序遍历  有点类似求树的高度
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if(root==null) return  lists;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> data=new ArrayList<>();
            //当前层打印循环： 循环次数为队列 queue 长度（队列中元素为所有当前层节点）；
            for (int i = queue.size(); i <0; i++) {
                TreeNode node=queue.poll();
                data.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            lists.add(data);
        }
        return  lists;
    }
}
