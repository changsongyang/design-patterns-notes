package com.github.algo.queue;



/**
 * 链表实现队列   单端队列
 *
 * @author qinxuewu
 * @create 20/2/16上午11:29
 * @since 1.0.0
 */


public class Queue<E> {
    private Node<E> first;
    private Node<E> last;

    private  int size;

    public int size() {
        return  size;
    }
    public boolean isEmpty() {
        return  size==0;
    }

    /**
     * 清空队列
     */
    public void clear() {
        first=null;
        last=null;
        size=0;
    }

    /**
     * 入队  添加队列尾部
     * @param element
     */
    public void enQueue(E element) {
        // 先获取当队列尾部的节点
        Node<E> oldLast=last;
        // 尾节点指向新创建的节点
        last=new Node<E>(oldLast,element,null);
        if(oldLast==null){
            // 表示是链表添加的第一个元素
            first=last;
        }else{
            // 原尾节点的next指向新的尾节点
            oldLast.next=last;
        }
        size++;
    }


    /**
     * 出队 队头出
     * @return
     */
    public E deQueue() {
        if(size==0){ return  null; }

        //  投节点先出
        Node<E> cur=first;
        Node<E> prev=cur.prev;
        Node<E> next=cur.next;


        if(prev==null){
            // 前指针为空 说明值头节点,移动头结点的位置到下一个节点
            first=next;
        }else{
            // 否则 删除节点的前一个节点的next指向删除节点的next指向的节点
            prev.next=next;
        }

        if (next == null) {
            //说明删除的是最后一个节点
            last = prev;
        } else {
            // 删除节点的下一个结点的前指针 指向删除节点的前一个节点
            next.prev = prev;
        }
        size--;
        return  cur.element;

    }

    /**
     * 访问队列头元素
     * @return
     */
    public E front() {
        return  first.element;
    }


    /**
     * 获取指定位置的节点
     * @param index
     * @return
     */
    private  Node<E> node(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
        Node<E> node = first;
        for (int i = 0; i <index ; i++) {
            node=node.next;
        }
        return  node;
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(11);
        queue.enQueue(22);
        queue.enQueue(33);
        queue.enQueue(44);

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }
}
