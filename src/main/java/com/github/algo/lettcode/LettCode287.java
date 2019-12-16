package com.github.algo.lettcode;

public class LettCode287 {


    /**
     * 抽屉问题是什么呢，简而言之就是把至少 n + 1个的苹果，按任意确定的方式分进n个抽屉里面，那么一定至少有一个抽屉中，含有至少两个苹果。
     *
     * 这道题也可以按照抽屉问题的思维来看，每次计算出 mid后，判断cnt>mid-l+1
     * 若结果是大于，则说明在 l→r 范围内的苹果，大于该范围内的抽屉数，所以这个范围内一定有重复的数。反之，则不存在。
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        // 利用抽屉算法
        // 抽屉原理：n+1 个苹果放在 n 个抽屉里，那么至少有一个抽屉中会放两个苹果。
        int l=1;
        int r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            int cnt=0;
            // 计算区间抽屉元素的个数
                for(int x:nums){
                    if(x>=1 && x<=mid){
                        cnt++;
                    }
                }
                if(cnt>mid-l+1){
                    r=mid;
                }else{
                    l=mid+1;
                }
        }
        return  l;
    }
}
