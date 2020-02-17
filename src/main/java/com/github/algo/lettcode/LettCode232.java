package com.github.algo.lettcode;


import java.util.Stack;

/**
 使用栈实现队列的下列操作：

 push(x) -- 将一个元素放入队列的尾部。
 pop() -- 从队列首部移除元素。
 peek() -- 返回队列首部的元素。
 empty() -- 返回队列是否为空。
 示例:

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class LettCode232 {

    /**
     * 利用两个栈实现  inStack   outStack
     *  入队时元素统一天骄到inStack
     *  出队时先判断outStack队列元素是否为空，如果为空则将inStack中元素入栈到outStack中
     *  如果outStack不为空 则从里面弹出栈顶元素
     */

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    public LettCode232() {
        inStack=new Stack<>();
        outStack=new Stack<>();
    }


    // 入队
    public void push(int x) {
        inStack.push(x);
    }


    // 出队
    public int pop() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    //  访问队列第一个元素
    public int peek() {
        return outStack.peek();
    }


    //  队列是否为空
    public boolean empty() {
        return  inStack.isEmpty()  && outStack.isEmpty();
    }
}
