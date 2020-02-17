package com.github.algo.queue;

/**
 * 双端队列
 *
 * @author qinxuewu
 * @create 20/2/17上午11:13
 * @since 1.0.0
 */


public class Deque<E> {
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
     * 出队 队头  先进的先出
     * @return
     */
    public E deQueueFront() {
        if(size==0){ return  null; }
        //  头节点先出
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
     * 入队  添加头部
     * @param element
     */
    public void enQueueFront(E element) {

        // 第一次添加
        if(size==0){
            // 既是头部 也是尾部添加  头尾相等
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, null);
            first = last;

        }else{
            // 不是第一次 往头部添加元素
            Node<E> oldFirst = first;
            Node<E> perv=oldFirst.prev;
            // 更新头节点
            first = new Node<>(perv, element, oldFirst);
            // 原始头节点的前指针 指向新的头节点;
            oldFirst.prev=first;
        }

        size++;
    }




    /**
     * 尾部入队
     * @param element
     */
    public void enQueueRear(E element) {
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
     * 尾部出队  队尾出 最后一个元素
     * @return
     */
    public E deQueueRear() {
        if(size==0){ return  null; }

        // 改变最后尾节点的指向
        Node<E> oldlast=last;
        Node<E> prev=oldlast.prev;
        Node<E> next=oldlast.next;

        //  尾节点的 前指针为空  说明 队列只剩下一个元素
        if(prev==null){
            //  直接投节点 变为尾节点的next指向  其实 最后都是null
            first=next;
        }else{
            // 给新尾节点的位置为 原头节点的前指针
            last=prev;
        }
        size--;
        return  oldlast.element;
    }


    /**
     * 访问头元素
     * @return
     */
    public E front() {
         return  first.element;
    }

    /**
     * 访问尾元素
     * @return
     */
    public E rear() {
        return last.element;
    }

    public static void main(String[] args) {
        Deque<Integer> queue = new Deque<>();
        // 先头部入队
		queue.enQueueFront(11);
		queue.enQueueFront(22);


		//  在尾部入队
		queue.enQueueRear(33);
		queue.enQueueRear(44);

		// 头出   22 11   33   44  尾  //

		/* 尾出  44  33   11  22  头 */

		while (!queue.isEmpty()) {
		    // 队尾出队
			System.out.println(queue.deQueueRear());
		}

    }
}
