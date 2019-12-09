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
    public TreeNode(int id,String name){
        this.id=id;
        this.name=name;
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

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
