package com.github.algo.tree;


import com.github.algo.TreeNode;
import com.github.algo.stack.Stack;
import lombok.val;

/**
 * 功能描述: 二叉树的 前序遍历 中序遍历 后续遍历
 *  区别：根节点的遍历顺序
 * @author: qinxuewu
 * @date: 2019/11/19 11:05
 * @since 1.0.0
 */
public class BinaryTree {


    public static void main(String[] args) {
        TreeNode root=new TreeNode(1,"A");

        TreeNode left1=new TreeNode(2,"B");
        TreeNode righr1=new TreeNode(5,"C");
        root.setLeft(left1);
        root.setRight(righr1);

        TreeNode left2=new TreeNode(3,"D");
        TreeNode righr2=new TreeNode(4,"E");
        left1.setLeft(left2);
        left1.setRight(righr2);


        TreeNode left3=new TreeNode(6,"F");
        TreeNode righr3=new TreeNode(7,"G");
        righr1.setLeft(left3);
        righr1.setRight(righr3);


//        System.out.println("前序遍历............ABDECFG.....");
////        preOrder(root);    // ABDECFG
//        System.out.println(preOrder(root,3).toString());
//        preOrder2(root);

        System.out.println("中序遍历...........DBEAFCG......");
        inorderOrder(root);
        inorderOrder2(root);



//        System.out.println("后序遍历..........DEBFGCA.......");
//        postOrder(root);

    }

    /**
     * 前序遍历: 根节点>左节点>右节点
     */
    public static   void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.toString());
        preOrder(root.getLeft());
        preOrder(root.getRight());

    }


    /**
     * 前序遍历查找指定的node
     * @param root
     * @param id
     * @return
     */
    public static   TreeNode preOrder(TreeNode root, int id){
        // 乳沟当前节点相同 则返回

        if(root==null){
            return  null;
        }
        if(root.getId()==id){
            return  root;
        }
        TreeNode temo=null;
        // 如果当前左子树不为空 则递归查找  找到则返回
        if(root.getLeft()!=null){
            temo=preOrder(root.getLeft(),id);
        }
        // 在左子树找到了  则返回
        if(temo!=null){
            return  temo;
        }
        if(root.getRight()!=null){
            temo=preOrder(root.getRight(),id);
        }
        return  temo;
    }


    /**
     * 中: 左节点>根节点》右节点
     */
    public static   void inorderOrder(TreeNode root){
        if(root==null){
            return;
        }
        inorderOrder(root.getLeft());
        System.out.println(root.toString());
        inorderOrder(root.getRight());
    }

    /**
     * 后续遍历: 左节点>右节点>根节点
     */
    public static   void postOrder(TreeNode root){
        if(root==null){
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.toString());
    }


    // 非递归前序遍历

    /**
     * 非递归前序遍历  根节点>左节点>右节点
     * 利用栈实现，首先遍历当前节点，然后判断当前节点的right子树是否为空，不为空则入栈
     * 然后记录遍历往左边遍历，当栈为空空时 则直接f返回
     * 不为空则pop出栈赋值给当前node
     * @param root
     */
    public static   void preOrder2(TreeNode root){
        if(root==null){
            return;
        }
        // 栈保存右子树
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while (true){
            if(node!=null){
                // 访问当前节点
                System.out.println(node.getName());
                // 右子树不为空 则入栈
                if(node.getRight()!=null){
                    stack.push(node.getRight());
                }
                // 向左走
                node=node.getLeft();
            }else if(stack.isEmpty()){
                return;
            }else {
                node=stack.pop();
            }
        }
    }


    /**
     * 非递归中序遍历 左节点>根节点》右节点  利用栈
     * 如果当前node 不为空  则把左节点入栈 并且继续往左走
     * 如果当然栈为null 直接返回
     * 栈不为空    则出栈元素赋值为当前node,  然后访问此节点。并且当前节点向右移动，继续遍历当节右节点的左子树
     * @param root
     */
    public static   void inorderOrder2(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode node=root;
        Stack<TreeNode> stack=new Stack<>();
        while (true){
            if(node!=null){
                stack.push(node);
                node=node.getLeft();
            }else if(stack.isEmpty()){
                return;
            }else{
                // 栈不为空
                node=stack.pop();
              // 访问node节点
                System.out.println(node.getName());
                // 往有节点进行中序遍历
                node=node.getRight();
            }
        }
    }


}


