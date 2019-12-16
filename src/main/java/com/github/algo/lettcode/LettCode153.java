package com.github.algo.lettcode;

public class LettCode153 {


    public static void main(String[] args) {
        for(int i=0;i<2;i++){

        }
        int [] nums={3,4,5,1,2};
       System.out.println(findMin(nums,1));
    }
    public static int findMin(int[] nums,int target) {
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid= l+(r-l)/2;
            // 如果nums[mid]大于数据最后的元素 说明无序数据出现在数组最右 则l=mid+1;
            if(nums[mid]>nums[r]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return nums[l];
    }
}

