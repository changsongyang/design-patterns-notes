package algo;
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
        quickSort(arr,0,arr.length-1);
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



    public  static void sort(int a[], int left, int right) {
        /*如果左边索引大于或者等于右边的索引就代表已经整理完成一个组了*/
            if(left >= right) {
                return ;
            }
            int i = left;
            int j = right;
            int key = a[left];
            while(i < j) {
                /*控制在当组内寻找一遍*/
                 while(i < j && key <= a[j]) {
                    j--;/*向前寻找*/
                }
                a[i] = a[j];
                while(i < j && key >= a[i]) {
                    i++;
                }
                a[j] = a[i];
            }
            a[i] = key;/*当在当组内找完一遍以后就把中间数key回归*/
            sort(a, left, i - 1);/*最后用同样的方式对分出来的左边的小组进行同上的做法*/
            sort(a, i + 1, right);/*用同样的方式对分出来的右边的小组进行同上的做法*/

        }

}
