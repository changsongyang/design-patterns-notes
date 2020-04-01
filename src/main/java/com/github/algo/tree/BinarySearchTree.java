package com.github.algo.tree;

import com.github.algo.tree.printer.BinaryTreeInfo;

import java.util.*;

/**
 * 二叉搜索树
 *
 * @author qinxuewu
 * @create 20/2/19上午10:49
 * @since 1.0.0
 */


public class BinarySearchTree<E>   implements BinaryTreeInfo {
    // 元素的数量
    private  int  szie;
    // 根节点
    private  Node<E> root;

    //  自定义比较器
    private Comparator<E> comparator;
    public  int szie(){ return  szie; }
    public  boolean isEmpty(){ return  szie==0 ;}

    public  BinarySearchTree(){
        this(null);
    }

    public BinarySearchTree(Comparator comparator){
        this.comparator=comparator;
    }

    /**
     * 清空元素
     */
    void  clear(){
        root=null;
        szie=0;

    }

    /***
     * 添加元素
     * 二叉搜索树 左子节点值小于等于父节点  右子节点的值大于等于根节点
     * @param element
     */
    public  void add(E element){
        // 非空检查
        if(element ==null){
            throw new IllegalArgumentException("element must not be null");
        }

        // 根节点为空 则表示添加的是第一个节点
        if(root==null){
            root=new Node<>(element,null);
            szie++;
            return;
        }


        // 添加的不是第一个节点的处理方式
        // 找到父节点  默认为root
        Node<E> parent = root;
        // 保存当前遍历的节点
        Node<E> node = root;
        // 保存要添加的方向 左 还是右
        int cmp=0;

        // 不为空空 则一直寻找插入位置 知道节点为空 则表示可以插入
        while (node!=null){
           // 比较插入节点和当前寻找插入节点的大小
            cmp=compare(element,node.element);
            // 更新父节点
            parent=node;

            if(cmp >0){
                // 大于0  则选择右子树
                node=node.right;
            }else if(cmp <0){
                // 小于0  则寻找左子树
                node=node.left;
            }else{
                // 如果相等 则覆盖当前的
                node.element=element;
            }
        }

        // 为空 说明已经找到了插入节点的父子节点了  看看是插入左还是右边
        Node<E> newNode=new Node<>(element,parent);
        if(cmp >0){
            parent.right=newNode;
        }else{
            parent.left=newNode;
        }
        szie++;
    }


    /**
     * 递归实现 前序遍历
     *  规则： 根节点>左节点>右节点
     */
    public void  preorderTraversal(){
        preorderTraversal(root);
    }
    private void  preorderTraversal(Node<E> node){
        if(node==null){ return; }
        System.out.println(node.element);
        preorderTraversal(node.left);
        preorderTraversal(node.right);

    }


    /**
     * 递归实现  中序遍历  中序遍历出的数据有有序的  升序 或降序
     * 规则 ：  左节点-》 根节点--》右节点
     */
//    public  void  inorderTraversal(){
//        inorderTraversal(root);
//    }
//    private   void  inorderTraversal(Node<E> node){
//        if(node==null){ return;}
//        inorderTraversal(node.left);
//        System.out.println(node.element);
//        inorderTraversal(node.right);
//    }

    public  void  inOrder(Visitor<E> visitor){
            inOrder(visitor,root);
    }

    private  void  inOrder(Visitor<E> visitor,Node<E> node){
        if(node==null || visitor.stop){
            return;
        }
        inOrder(visitor,node.left);

        if(visitor.stop){
            return;
        }
        visitor.stop= visitor.visit(node.element);
        inOrder(visitor,node.right);

    }


    /**
     * 递归实现  后序遍历
     * 规则  左节点 -》 右节点-》 根节点
     */
    public  void postorderTraversal(){
        postorderTraversal(root);
    }

    private   void postorderTraversal(Node<E> node){
        if(node==null){ return;}
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.element);

    }

    /***
     * 层序遍历  一层层遍历
     * 使用队列实现 : 将根节点入队 。然后循环执行以下操作：
     *                          将队列头节点处出队  进行访问， 将当前出队的节点的左子树和右子树分别入队
     */
    public void levelOrderTraversal(){
        if(root==null){ return;}
        // 将根节点入队

        Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
		    // 出队
		    Node<E> node=queue.poll();
            System.out.println(node.element);

		    if(node.left!=null){
		        queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
         }

    }


    /**
     * 层序遍历   自定义元素处理方式  通过传入一个接口行为
     * @param visitor
     */
    public void levelOrder(Visitor<E> visitor){
        if(root==null){ return;}
        // 将根节点入队
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            // 出队
            Node<E> node=queue.poll();

            // 元素处理方式 传入一个接口行为
            if(visitor.visit(node.element)){ return; }


            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }

    }


    /**
     * 层序遍历 求树的高度
     * @return
     */
    public  int  height(){
        if(root==null){ return 0;}
        Queue<Node<E>> queue=new LinkedList<>();
        queue.offer(root);
        // 树的高度
        int height = 0;
        // 存储着每一层的元素数量
        int levelSize = 1;
        while (!queue.isEmpty()){
            Node<E> node=queue.poll();
            levelSize--;
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }

            if(levelSize==0){
                levelSize = queue.size();
                height++;
            }
        }
        return  height;
    }

    /**
     * 删除元素
     * @param element
     */
    public  void remove(E element){

    }

    /**
     * 是否包含元素
     * @param element
     * @return
     */
    boolean contains(E element){
        return  false;
    }

    /**
     *
     * 返回值等于0，代表e1和e2相等；
     * 返回值大于0，代表e1大于e2；
     * 返回值小于于0，代表e1小于e2
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }


    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>)node;

        return myNode.element;
    }

    //  遍历方式接口
    public static abstract class Visitor<E> {
        boolean stop;
        /**
         * @return 如果返回true，就代表停止遍历
         */
        public abstract boolean visit(E element);
    }


}
