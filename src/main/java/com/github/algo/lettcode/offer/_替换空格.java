package com.github.algo.lettcode.offer;


/**
 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。


 示例 1：

 输入：s = "We are happy."
 输出："We%20are%20happy."

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _替换空格 {

    public static void main(String[] args) {

    }

    /**
     * 使用字符数组， 替换从 1 个字符变成 3 个字符， 所以字符数组应该为字符串长度的三倍
     * 定义初始下标size=0, 循环遍历字符串，
     *      当前字符是空格时 则arr[szie++]='%',arr[szie++]='2',arr[szie++]='0',
     *      不是空格 则arr[size++]=cur
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        int leng=s.length();
        char[] arr=new char [leng*3];
        int size=0;
        for (int i = 0; i <leng ; i++) {
            char cur=s.charAt(i);
                if(cur==' '){
                    // 如果是空 则转换
                    arr[size++]='%';
                    arr[size++]='2';
                    arr[size++]='0';
                }else{
                    arr[size++]=cur;
                }
        }
        String newStr=new String(arr,0,size);
        return newStr;
    }
}
