package com.github.algo.lettcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [20,9],
 [15,7]
 ]
  

 提示：

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _从上到下打印二叉树3 {


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

        boolean falg=true;
        while (!queue.isEmpty()){
            int szie=queue.size();
            List<Integer> data=new ArrayList<>();
            //当前层打印循环： 循环次数为队列 queue 长度（队列中元素为所有当前层节点）；
            for (int i = 0; i <szie; i++) {
                TreeNode node=queue.poll();
                if(falg)   data.add(node.val);
                else   data.add(0,node.val);

                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            falg = !falg;
            lists.add(data);
        }
        return  lists;
    }
}
