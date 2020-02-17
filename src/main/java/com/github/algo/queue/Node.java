package com.github.algo.queue;

/**
 * 双链表节点
 *
 * @author qinxuewu
 * @create 20/2/16上午11:32
 * @since 1.0.0
 */


public class Node<E> {

    E element;
    Node<E> prev;
    Node<E> next;

    public Node(Node<E> prev, E element, Node<E> next) {
        this.prev = prev;
        this.element = element;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (prev != null) {
            sb.append(prev.element);
        } else {
            sb.append("null");
        }

        sb.append("_").append(element).append("_");

        if (next != null) {
            sb.append(next.element);
        } else {
            sb.append("null");
        }

        return sb.toString();
    }
}
