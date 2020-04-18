package com.github.algo.lettcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

  

 示例 1：

 输入: s = "abcdefg", k = 2
 输出: "cdefgab"
 示例 2：

 输入: s = "lrloseumgh", k = 6
 输出: "umghlrlose"

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class _左旋转字符串 {

    public static void main(String[] args) {

        System.out.println(reverseLeftWords("abcdefg",2));
    }

    /**
     * 解法1： 利用Java  api 实现字符串切割在拼接
     *
     *  s[n:s.length]+s[0:n]
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
       return s.substring(n,s.length())+s.substring(0,n);
    }


    /**
     * 解法2：列表拼接方法，
     * @param s
     * @param n
     * @return
     */
    public  static  String reverseLeftWords2(String s,int n){

        StringBuilder str=new StringBuilder();

        // 先凭借从开始到结束的字符串
        for (int i = n; i <s.length() ; i++) {
            str.append(s.charAt(i));
        }

        for (int j = 0; j <n ; j++) {
            str.append(s.charAt(j));
        }

        return  str.toString();

    }
}
