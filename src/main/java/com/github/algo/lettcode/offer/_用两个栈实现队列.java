package com.github.algo.lettcode.offer;


import com.github.algo.stack.Stack;

/**
 用两个栈实现一个队列。队列的声明如下，
 请实现它的两个函数 appendTail 和 deleteHead ，
 分别完成在队列尾部插入整数和在队列头部删除整数的功能
 (若队列中没有元素，deleteHead 操作返回 -1 )

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _用两个栈实现队列 {
    // 队列的入栈
    Stack<Integer> inStack;
    // 队列的出栈栈
    Stack<Integer> outStack;

    public _用两个栈实现队列() {
     inStack=new Stack<>();
     outStack=new Stack<>();
    }

    /**
     * 队列尾部插入整数
     *  直接插入inStack
     * @param value
     */
    public void appendTail(int value) {
        inStack.push(value);
    }

    /**
     * 队列头部删除整数
     *  出队时  如果outStack为null 则将 inStack栈弹出push到outStack
     *  如果outStack不为null 则弹出栈顶元素
     *
     * @return
     */
    public int deleteHead() {
            if(outStack.isEmpty()){
                    while (!inStack.isEmpty()){
                        outStack.push(inStack.pop());
                    }
            }
        return  outStack.isEmpty()?-1:outStack.pop();
    }

    public static void main(String[] args) {
        _用两个栈实现队列  ss=new _用两个栈实现队列();
        ss.appendTail(1);
        ss.appendTail(2);
        ss.appendTail(3);
        System.out.println(ss.deleteHead());

        ss.appendTail(4);
        System.out.println(ss.deleteHead());
        System.out.println(ss.deleteHead());
        System.out.println(ss.deleteHead());
    }
}
