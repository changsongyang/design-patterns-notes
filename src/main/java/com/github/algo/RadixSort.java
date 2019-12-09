package com.github.algo;
import java.util.Arrays;

/**
 * 功能描述: 基数排序
 *  基数排序属于“分配式排序”，又称“桶子法”，它是通过将数据中的元素从个位，位，百位..等等，
 *      分别放入0-9下标的10个不同的桶中，然后在取出，以为达到排序的作用。
 * @author: qinxuewu
 * @date: 2019/11/13 9:34
 * @since 1.0.0
 */
public class RadixSort {

    public static void main(String[] args) {
        int [] arr={53,3,542,748,12,214};
        sort(arr);
    }

    public  static  void  sort(int [] arr){
        // 找出数组中最大数的的位数
        int max=arr[0];
        for (int i = 1; i <arr.length ; i++) {
                if(arr[i]>max){
                    max=arr[i];
                }
        }
        // 利用字符串特性 计算是几位数
        int maxLength=String.valueOf(max).length();

        // 定义一个二维数组，表示10个桶 每个桶就是一维数组
        int[][] bucket=new int[10][arr.length];

        // 使用一个一维数组 记录每个桶中放了多少数据
        // 比如bucketElementCount[0] 就是第bucket[0]桶放入的数据个数
        int [] bucketElementCount=new  int[10];
        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            // 循环放入各个桶中  分别处理个位 十位，百位...
            // n 就是代表处理到哪一位了 n*=10 每遍历一次循环 就是乘10  方便后面取模每次除以N后的个位
            // 第1轮 n=1  n=10
            // 第2轮 n=2  n=100
            // 第3轮 n=3  n=1000

            for (int j = 0; j <arr.length ; j++) {
                // 取出每个元素对应的位置
                int digitOfElement=(arr[j] / n) % 10;
                // 放入对应的桶中
                bucket[digitOfElement][bucketElementCount[digitOfElement]]=arr[j];
                bucketElementCount[digitOfElement]++;
            }
            // 按照桶的顺序 依次取出数据，放入原来的数组
            int inex=0;
            // 遍历每一个桶 并将桶中的数据 放入原数组
            for (int k = 0; k < bucketElementCount.length; k++) {
                    // 如果桶中有数据 才放入原数组
                if (bucketElementCount[k]!=0){
                    // 循环该桶 放入
                    for (int l = 0; l <bucketElementCount[k] ; l++) {
                        // 第K个桶的下标为l的数据
                            arr[inex++]=bucket[k][l];
                    }
                }
                // i+1 轮处理后 归0
                bucketElementCount[k]=0;
            }

            System.out.println("第"+(i+1)+"轮,对个位的排序处理 arr="+ Arrays.toString(arr));
        }
    }

}
