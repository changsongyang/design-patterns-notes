package com.github.algo.lettcode.offer;



/**
 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

 示例 1：

 输入: "  the sky is blue"
 输出: "blue is sky the"


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _翻转单词顺序 {

    public static void main(String[] args) {
        String s="  the sky is blue";
        System.out.println(reverseWords(s));
    }


    /**
     * 解法1：先切割 然后在从新拼接
     * @param s
     * @return
     */
    public  static  String reverseWords(String s) {
        String[] arr=s.split(" ");
        StringBuilder st=new StringBuilder();

        for (int i = arr.length-1; i>=0 ; i--) {
            if(!arr[i].equals("")){
                st.append(arr[i]);
                st.append(" ");
            }
        }

        return  st.toString().trim();
    }
}
