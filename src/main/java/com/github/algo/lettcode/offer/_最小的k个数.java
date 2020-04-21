package com.github.algo.lettcode.offer;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。


 示例 1：

 输入：arr = [3,2,1], k = 2
 输出：[1,2] 或者 [2,1]
 示例 2：

 输入：arr = [0,1,2,1], k = 1
 输出：[0]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _最小的k个数 {


    public static void main(String[] args) {
        int []arr={3,2,1};
        int k=2;

        getLeastNumbers(arr,k);

    }

    /**
     * 保利破解法 先排序  才取最小的k个数
     * @return
     */
    public static int[] getLeastNumbers1(int[] arr, int k) {

        for(int i=1;i<arr.length;i++){
            int pos=i;
            int temp=arr[pos];
            while(pos >0 && arr[pos-1] > temp){
                    arr[pos]=arr[pos-1];
                    pos=pos-1;
            }
            arr[pos]=temp;
        }
        System.out.println("排序后的数组"+ Arrays.toString(arr));

        // 取前K个
        int [] newArr=new int[k];

        for(int j=0;j<k;j++){
            newArr[j]=arr[j];
        }
        System.out.println("最小的 k 个数"+ Arrays.toString(newArr));
        return  newArr;
    }

    /**
     * 维护一个大顶堆：将
     *  1. 数组中的元素依次入堆，当堆的大小超过K时，就将多的元素从对顶弹出
     *  2. 由于每次从堆顶弹出的数都是堆中最大的，最小的 k 个元素一定会留在堆里
     *  3. 这样把数组中的元素全部入堆之后，堆中剩下的 k 个元素就是最大的 k 个数了。
     *
     *  使用PriorityQueue优先级队列实现，默认是小顶堆，添加 comparator 参数使其变成最大堆
     *
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        if(k==0) {
            return  new int[0];
        }
        // 维护一个大顶堆
        Queue<Integer> heap=new PriorityQueue<>(k,(a,b)-> Integer.compare(b,a));
        // 将数组中 的元素 依次入堆
        for(int i=0;i<arr.length;i++){
            // 当前数字小于堆定元素才入堆
            if(heap.isEmpty() || heap.size() < k || arr[i] < heap.peek()){
                // 当堆为空 或 大顶堆中元素数量小于K  或当前元素小于堆顶元素 就入堆
                heap.offer(arr[i]);
            }
            // 当大顶堆元素 大于K个数时  将堆顶元素弹出
            if(heap.size() > k){
                heap.poll();
            }
        }

        //  最后堆中的元素 就top K
        int [] newArr=new int[k];
        int j=0;
        for(int e:heap){
            newArr[j++]=e;
        }
        System.out.println("最小的 k 个数"+ Arrays.toString(newArr));
        return  newArr;

    }
}
