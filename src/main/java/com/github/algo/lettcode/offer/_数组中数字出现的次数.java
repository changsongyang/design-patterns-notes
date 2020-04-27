package com.github.algo.lettcode.offer;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 一个整型数组 nums 里除两个数字之外，
 其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

  
 示例 1：

 输入：nums = [4,1,4,6]
 输出：[1,6] 或 [6,1]
 示例 2：

 输入：nums = [1,2,10,4,1,4,3,3]
 输出：[2,10] 或 [10,2]
  

 限制：

 2 <= nums <= 10000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _数组中数字出现的次数 {

    public static void main(String[] args) {
        int []nums={1,2,10,4,1,4,3,3};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }

    /**
     * 空间复杂度不是O(1)的解法
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            if(!set.contains(nums[i])){
                    set.add(nums[i]);
            }else{
                set.remove(nums[i]);
            }
        }
        int []arr=new int[set.size()];
        int j=0;
        for(int i:set){
            arr[j++]=i;
        }
        return  arr;
    }




}
