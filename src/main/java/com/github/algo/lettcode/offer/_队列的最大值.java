package com.github.algo.lettcode.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

 若队列为空，pop_front 和 max_value 需要返回 -1

 示例 1：

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _队列的最大值 {


    // 解题思路：利用一个主队列和辅助队列实现
    // 主队列添加元素时，清除掉辅助队中元素比当前元素小的值，然后把当前元素也加入辅助队列中尾部
    // 出队列时 主队列出队后， 判断当前主队列出队元素和辅助队列头部元素是否相等，相等则辅助队列出队

    Queue<Integer> master;
    Deque<Integer> slave;
    public _队列的最大值() {
        master=new LinkedList<>();
        slave=new LinkedList<>();
    }

    public int max_value() {
        if(slave.isEmpty()) return  -1;
        // 返回辅助队列队头元素
        return  slave.peek();
    }

    public void push_back(int value) {
        // 主队列先入队
        master.add(value);
        // 如果辅助队列中尾元素 小于当前元素，则清除尾辅助队列尾部元素
        while (!slave.isEmpty() && slave.peekLast() < value){
            slave.removeLast();
        }
        // 如果当前元素大于辅助队列头部元素 则当前元素加入复制队列中
        slave.add(value);
    }

    public int pop_front() {
        if(master.isEmpty()) return  -1;
        //  主队列先出队
       int value= master.poll();
       // 如果 当前主队列出队元素和辅助队列头部元素相同 则辅助队列也出队
        if (value==slave.peek()){
            slave.poll();
        }
        return value;
    }
}
