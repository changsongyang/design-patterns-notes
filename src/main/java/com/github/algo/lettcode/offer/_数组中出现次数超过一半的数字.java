package com.github.algo.lettcode.offer;


/**
 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

  

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

  

 示例 1:

 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 输出: 2
  

 限制：

 1 <= 数组长度 <= 50000

  

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _数组中出现次数超过一半的数字 {


    /**
     哈希表统计法： 遍历数组 nums ，用 HashMap 统计各数字的数量，最终超过数组长度一半的数字则为众数。此方法时间和空间复杂度均为 O(N)O(N) 。
     数组排序法： 将数组 nums 排序，由于众数的数量超过数组长度一半，因此 数组中点的元素 一定为众数。此方法时间复杂度 O(N log_2 N)O(Nlog
     2
     ​
     N)。
     摩尔投票法： 核心理念为 “正负抵消” ；时间和空间复杂度分别为 O(N)O(N) 和 O(1)O(1) ；是本题的最佳解法。
     */
    public int majorityElement(int[] nums) {
        // 初始化投票数votes=0， 众数为x(nums[0])
        // 开始遍历数据投票，如果循环中
        int votes=0;
        int x=0;
        for (int num:nums){
            // 如果票数为0  则更新众数为当前元素
           if(votes==0){
               x=num;
           }
           // 如果元素和众数相同 则票数加1  否则 票数减1
           votes+= num==x? 1:-1;
        }
        return x;
    }


}
