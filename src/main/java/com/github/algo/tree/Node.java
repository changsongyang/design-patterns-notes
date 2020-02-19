package com.github.algo.tree;

public  class Node<E> {
    E element;
    Node<E> left;
    Node<E> right;
    Node<E> parent;
    public Node(E element, Node<E> parent) {
        this.element = element;
        this.parent = parent;
    }


}