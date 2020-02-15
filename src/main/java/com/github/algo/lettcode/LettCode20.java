package com.github.algo.lettcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:

 输入: "()"
 输出: true
 示例 2:

 输入: "()[]{}"
 输出: true
 示例 3:

 输入: "(]"
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class LettCode20 {

    /**
     * 使用栈实现  如果左字符则入栈，遇到右字符，如果栈是空的则说明无效， 如果栈不为空 则出栈和右字符匹配
     *              如果左右匹配 则继续扫描下一个字符 否则不匹配
     *              扫描完后 栈为空 则说明是有效的括号  栈不为空 则说明无效括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');

        Stack<Character> stack=new Stack<>();
        int len=s.length();
        for (int i = 0; i < len ; i++) {
            char c=s.charAt(i);
            if(!map.containsKey(c)){
                // map中不存在 说明是右字符  则出栈和左字符匹配
                if(stack.isEmpty()) {return  false;}

                //  如果栈不为空 则出栈和右字符匹配
               char left=stack.pop();
               if(map.get(left)!=c) {return  false;}

            }else{
                // 存在 说明是左字符 则入栈
                stack.push(c);
            }
        }
        return  stack.isEmpty();
    }
}
