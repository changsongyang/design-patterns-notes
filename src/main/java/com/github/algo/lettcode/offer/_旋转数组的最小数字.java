package com.github.algo.lettcode.offer;



/**
 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

 示例 1：

 输入：[3,4,5,1,2]
 输出：1
 示例 2：

 输入：[2,2,2,0,1]
 输出：0

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _旋转数组的最小数字 {

    public static void main(String[] args) {

    }

    /**
     * 爆料破解法：先排序 在取下标0的元素
     * 二分法：虽然二分是要数组有序的情况下才可以， 但是一般有序也可以使用二分，
     *  求出中间值值，当 numbers[mid] 值大于右边的元素，说明中间值右边的元素不是有序的，且最小值一定出现在右边，则缩小二分的区间为[mid+1,right]
     *  当 numbers[mid] 值小于右边的元素，说明最小元素只可能出现在中间值左边  则缩小二分范围[left,mid]
     *  当 numbers[mid] 等于右边元素时，则可以排除最右边的元素,缩小二分范围[left,right-1];
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int len=numbers.length;
        int left=0;
        int right=len-1;

        while (left < right){
            int mid=(left+right)>>1;
            if(numbers[mid] > numbers[right]){
                // 中间值比右边元素 则缩二分范围[mid+1,right];
                left=mid+1;
            }else if(numbers[mid]==numbers[right]){
                right--;
            }else{
                // 小于 则二分范围缩小[left,mid]
                right=mid;
            }
        }
        return  numbers[left];
    }
}
