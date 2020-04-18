package com.github.algo.lettcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 面试题53 - I. 在排序数组中查找数字 I
 统计一个数字在排序数组中出现的次数。



 示例 1:

 输入: nums = [5,7,7,8,8,10], target = 8
 输出: 2
 示例 2:

 输入: nums = [5,7,7,8,8,10], target = 6
 输出: 0
 */


public class _在排序数组中查找数字 {


    public  static int search(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        return map.get(target);
    }

    public static void main(String[] args) {
       int [] nums ={5,7,7,8,8,10};
       int target = 8;
       System.out.println(search(nums,target));
    }
}
