package com.github.algo.queue;

/**
 * 功能描述: 基于数组实现的队列- 目前没有达到服用的效果
 * @author: qinxuewu
 * @date: 2019/10/21 9:47
 * @since 1.0.0
 */
public class ArrayQueue {

    /** 队列元素  **/
    private  int []data;
    /** 队列最大容量  **/
    private  int n;
    private  int head;
    private  int tail;


    public  ArrayQueue(int n){
        this.data=new int[n];
        this.n=n;
        this.head=-1;
        this.tail=-1;
    }

    /** 判断队列是否为空  **/
    public boolean isEmpty(){
        return head==tail;
    }


    /** 判断队列是否已满 **/
    public boolean isFull(){
        return  tail==n-1;
    }

    /** 入队  队尾入**/
    public void  addQueue(int value){
        if(isFull()){
            throw new RuntimeException("队列已满");
        }
        tail++;  // 尾指针后移

        data[tail]=value;
    }

    /** 出兑  队头出**/
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空");
        }
        head++;
        return data[head];
    }


    public  void  showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空");
        }
       StringBuilder str=new StringBuilder();
        for (int i = 0; i <data.length ; i++) {
            str.append(data[i]).append(",");
        }
        System.out.println(str.toString());
    }

    public static void main(String[] args) {
        CircleArrayQueue queue=new CircleArrayQueue(4);  //  环形队列设置4  有效数据3
        queue.addQueue(1);
        queue.addQueue(1);
        queue.addQueue(3);
        System.out.println(queue.size());
        System.out.println("出队:"+queue.getQueue());
        System.out.println(queue.size());


        queue.addQueue(4);
        System.out.println(queue.size());



    }




}
