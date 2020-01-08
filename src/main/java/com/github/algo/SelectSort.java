package com.github.algo;
import java.util.Arrays;


/**
 * 功能描述: 选择排序
 * @author: qinxuewu
 * @date: 2019/10/22 17:01
 * @since 1.0.0
 */
public class SelectSort {

    public static void main(String[] args) {
        int [] arr={4,1,7,3};
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex=i;  // 默认最小元素下标
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j]<arr[minIndex]){
                    //如果当前元素 小于最小下标的元素，则替换当前元素下标 为最小元素下标
                    minIndex=j;
                }

            }
            // 一轮循环结束 交互位置
            if(minIndex !=i){
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // 用来记录最小值的索引位置，默认值为i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // 遍历 i+1~length 的值，找到其中最小值的位置
                }
            }
            // 交换当前索引 i 和最小值索引 minIndex 两处的值
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            // 执行完一次循环，当前索引 i 处的值为最小值，直到循环结束即可完成排序
        }
    }


}
