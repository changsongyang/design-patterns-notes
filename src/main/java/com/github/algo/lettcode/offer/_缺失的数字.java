package com.github.algo.lettcode.offer;

/**
 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

  

 示例 1:

 输入: [0,1,3]
 输出: 2
 示例 2:

 输入: [0,1,2,3,4,5,6,7,9]
 输出: 8
  

 限制：

 1 <= 数组长度 <= 10000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class _缺失的数字 {


    public static void main(String[] args) {
        int [] nums={0,1,3};

        System.out.println(missingNumber(nums));

    }


    /**
     * 二分查找法： 如果当前数字与当前位置相等，则说明前面的数字都没有缺失，直接继续对后面的数字进行二分查找。
     * 直到无法二分查找的时候，我们判断low位置的数字是否等于low，等于则+1，不等则-1。
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {

        int low=0;
        int high=nums.length-1;

        while (low < high){
            int mid=(low+high)/2;

            if(nums[mid]==mid){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return  nums[low]==low ? nums[low]+1:nums[low]-1;
    }
}
