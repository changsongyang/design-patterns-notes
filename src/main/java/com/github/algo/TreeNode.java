package com.github.algo;


/**
 * 功能描述:  二叉树的数据结构
 * @author: qinxuewu
 * @date: 2019/11/19 11:12
 * @since 1.0.0
 */
public class TreeNode {

    private  int id;
    private String name;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    public TreeNode(int id,String name,TreeNode parent){
        this.id=id;
        this.name=name;
        this.parent=parent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
