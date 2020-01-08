package com.github.algo.lettcode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LettCode1 {
    public static void main(String[] args) {
       int[] nums = {2, 7, 11, 15};
       int target = 9;
       int []res= twoSum(nums,target);
       System.out.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int res=target-nums[i];
            if(map.containsKey(res)){
                return new int[]{map.get(res),i};
            }
            // 存储当前 索引的值 和索引
            map.put(nums[i],i);
        }

        return  null;
    }
}
