package com.github.algo.lettcode.offer;


import java.util.Stack;

/**
 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 参考以下这颗二叉搜索树：

  5
 / \
 2   6
 / \
 1   3
 示例 1：

 输入: [1,6,3,2,5]
 输出: false
 示例 2：

 输入: [1,3,2,6,5]
 输出: true
  

 提示：
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _二叉搜索树的后序遍历序列 {


    /**
     *  后序遍历定义：，即遍历顺序为 “左、右、根” 。
     *  二叉搜索树定义： 左子树中所有节点的值 << 根节点的值；右子树中所有节点的值 >> 根节点的值；其左、右子树也分别为二叉搜索树。
     *
     *   初始化： 单调栈 stackstack ，父节点值（初始值为正无穷大，可把树的根节点看为此无穷大节点的左孩子）；
     *   倒序遍历数组，假设当前节点为r
     *     1. 判断当前节点 "i > root"  ，如果条件成立 说明此后续遍历不满足二叉树  直接返回false
     *     2. 当栈不为空时，判断栈顶元素是否 stack.peek()>arr[i] ，如果成立则更新root=stack.pop()
     *     3. 入栈： 将当前节点放入栈中
     */
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack=new Stack<>();

        int root=Integer.MAX_VALUE;
        for (int i = postorder.length-1; i>=0 ; i--) {
            if(postorder[i] > root)  return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]){
                root=stack.pop();
            }
            stack.add(postorder[i]);
        }
        return  true;
    }
}
