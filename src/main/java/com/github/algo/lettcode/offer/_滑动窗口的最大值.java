package com.github.algo.lettcode.offer;


import java.util.Arrays;
import java.util.LinkedList;

/**
 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

 示例:

 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7]
 解释:

 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
  

 提示：

 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _滑动窗口的最大值 {


    /**
     * 解题思路： 单调的双向队列就是，人为维护从队列的头部到尾部，所存储的元素是依次递减（变小）的
     *  1. 维护一个单调的双向队列，窗口在每次滑动的时候，我就从队列头部取当前窗口中的最大值，
     *  2. 每次窗口新进来一个元素的时候，我就将它与队列中的元素进行大小比较：
     *  3. 如果刚刚进来的元素比队列的尾部元素大，那么先将队列尾部的元素弹出，然后把刚刚进来的元素添到队列的尾部；
     *  4. 如果刚刚进来的元素比队列的尾部元素小，那么把刚刚进来的元素直接添到队列的尾部即可。
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || k < 1 ||nums.length <k){
            return  new int[0];
        }
        int index=0;
        int [] res=new int[nums.length-k+1];
        LinkedList<Integer> queue=new LinkedList<>();
        for (int i = 0; i <nums.length ; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                // 队列不为空 且队列尾部的元素要比当前元素小
                // 为了维持从大到小的原则，我必须让尾部元素弹出
                queue.pollLast();
            }
            // 否则说明队列尾部的元素 比当前元素大  则添加到队列尾部
            queue.addLast(i);
                //如果当前索引减去窗口大小所得的值等于头部的值，则说明过期了
            if(queue.peekFirst()== (i-k)){
                queue.pollFirst();
            }
            // 看看窗口有没有形成，只有形成了大小为 k 的窗口，我才能收集窗口内的最大值

            // 从索引 2 开始才形成窗口
            if(i>=(k-1)){
                // 每次窗口的最大值就是队头元素的索引所对应的值
                res[index++]=nums[queue.peekFirst()];
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
    }

}
