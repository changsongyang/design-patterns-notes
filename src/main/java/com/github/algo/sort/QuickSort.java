package com.github.algo.sort;
import java.util.Arrays;

/**
 * 功能描述: 递归快速排序
 *          思路:  快排的思路是利用分治法的思想，选取基准元素，然后不断的把基准元素两侧的分区数组在执行基准元素的选择和分区
 *           一直到达每个分区剩下0或1个元素则介绍递归，
 *
 *           分区指的是从数组随机选取一个值，以其为轴，将比它小的值放到它左边，比它大的值放到它右边
 *           然后放置指针，它们应该分别指向排除轴元素的数组最左和最右的元素。
 *           接着就可以分区了，步骤如下：
 *           1）左指针逐个格子向右移动，当遇到大于或等于轴的值时，就停下来。
 *           2）右指针逐个格子向左移动，当遇到小于或等于轴的值时，就停下来。
 *           3）将两指针所指的值交换位置
 *           4）重复上述步骤，直至两指针重合，或左指针移到右指针的右
 *           5）将轴与左指针所指的值交换位置。
 *           当分区完成时，在轴左侧的那些值肯定比轴要小，在轴右侧的那些值肯定比轴要大。因此，轴的位置也就确定了，虽然其他值的位置还没有完全确定。
 * @author: qinxuewu
 * @date: 2019/10/25 11:44
 * @since 1.0.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] arr={0,5,2,6,3};
        sort2(arr,0,arr.length-1);
        System.out.println("Sorting: " + Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int low, int high){
        if(low>=high){ return; }
        int left=low;
        int right=high;
        // 从数组随机选取一个值，以其为轴
        int temp=arr[left];
        while (left <right){
            // 当右指针的值大于等于轴的值 则向左移
            while (left < right && temp <= arr[right] ){
                right--;
            }
            arr[left] = arr[right];

            // 当左指针的值小于等于轴的值 则向右移
            while (left < right && temp >= arr[left] ){
                left++;
            }
            // 将两指针所指的值交换位置
            arr[right]=arr[left];
        }
         // 当在当组内找完一遍以后就把中间数key回归
        arr[left]=temp;
        /*最后用同样的方式对分出来的左边的小组进行同上的做法*/
        quickSort(arr,low,left-1);
        /*用同样的方式对分出来的右边的小组进行同上的做法*/
        quickSort(arr,left+1,high);
    }


    /**
     * 快速排序是对冒泡排序的一种改进，基本思想是通过一趟排序将要排序的的数据分割成独立的两部分
     *  其中一部分数据比另一部分数据所有的元素小，然后按此方法对着两部分数据进行快速排序，这个排序过程可以递归进行，以此达到整个数据变成有序序列
     * @param arr
     * @param left
     * @param right
     */
    public  static  void   sort2(int []arr,int left,int right){
         int l=left;
         int r=right;
         int point=arr[(left+right)/2];  // 中轴值
        int temp=0; // 临时变量 作为交换使用

        // 循环的目的是让比中轴值大的元素放在右边
         while (l<r){
             // point的左边一直查找，找到比point大就退出
             while (arr[l] < point){
                    l+=1;
                }
             // point的右边一直查找，找到比point小于等于的值就退出
             while (arr[r] > point){
                 r-=1;
             }
             // 如果l>=r 说明point的左右两边的值 已经是按照左边的全是
             // 小于等于point ,右边全部是大于等于point
             if(l>=r){
                 break;
             }

             // 交换
             temp=arr[l];
             arr[l]=arr[r];
             arr[r]=temp;

             // 交换完后 发现arr[l]==point相等 则r-- 左移
             if(arr[l]==point){
                 r--;
             }
             // 交换完后 发现arr[r]==point相等 则l++ 右移
             if(arr[r]==point){
                 l++;
             }
            // 如果l==r 则必须l++, r-- 否则栈溢出
             if(l==r){
                l++;
                r--;
             }
             // 左递归
             if(left<r){
                 sort2(arr,left,r);
             }
             // 右递归
             if(right>l){
                 sort2(arr,l,right);
             }
         }
    }



}
