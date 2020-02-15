package com.github.algo.sort;


import java.util.Arrays;

/**
 * 功能描述: 希尔排序
 *
 *  首先它把较大的数据集合分割成若干个小组（逻辑上分组），
 *  然后对每一个小组分别进行插入排序，此时，插入排序所作用的数据量比较小（每一个小组），插入的效率比较高
 * @author: qinxuewu
 * @date: 2019/11/4 17:00
 * @since 1.0.0
 */
public class ShellSort {

    public static void main(String[] args) {
        int [] arrr={8,9,1,7,2,3,5,4,6,0};
        int n=arrr.length;
        for (int gap = n/2; gap >0 ; gap /=2) {
            for (int i = gap; i < n; i++) {
                // 遍历各组中所有的元素(共gap组)，步长gap
                for (int j = i-gap; j >=0 ; j-=gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交互
                    if(arrr[j]>arrr[j+gap]){
                        int temp=arrr[j];
                        arrr[j]=arrr[j+gap];
                        arrr[j+gap]=temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arrr));
        }
    }
}
