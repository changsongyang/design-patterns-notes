package com.github.algo.lettcode;


import java.util.HashSet;
import java.util.Set;

/**
 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 */
public class LettCode3 {
    public static void main(String[] args) {

    }

    /**
     *
     * 爆力破解法：遍历所有的字符串可组合的类型 放入set集合中 放入前先判断一下是 存在返回true 则循环结束
     * 设开始和结束的索引分别为 ii和 j。那么我们有 0<i<j<n。
     * 因此，使用 i从 0到 n −1 以及 j 从 i+1 到n 这两个嵌套的循环，我们可以枚举出 s 的所有子字符串。
     * 当set中存在组合的类型时  j-i就是无重复最长字符串的长度了
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
          int ans=0;
          for (int i=0;i<s.length();i++){
              for (int j=i+1;j<s.length();j++){
                    if(check(s,i,j)){
                        ans=Math.max(ans,j-i);
                    }
              }
          }
          return ans;
    }

    public  boolean check(String s,int start,int end){
        Set<Character> set=new HashSet<>();
        for (int i=start;i< end;i++){
            Character ch=s.charAt(i);
            if(set.contains(ch)){
                return  false;
            }else{
                set.add(ch);
            }
        }
        return  true;
    }
}
