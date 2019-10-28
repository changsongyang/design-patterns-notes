package algo;

import java.util.Arrays;


/**
 * 功能描述: 插入排序
 * @author: qinxuewu
 * @date: 2019/10/25 9:37
 * @since 1.0.0
 */
public class InsertSort {

    public static void main(String[] args) {
        int [] arrr={4,1,7,3,5};
        for (int i = 1; i < arrr.length; i++) {
                    int min=i;
                    int temp=arrr[min];
                    while (min>0 && arrr[min-1] > temp){
                        arrr[min]=arrr[min-1]; // temp左侧值右移
                        min=min-1;
                    }
                    // 已经到最左侧或 temp左侧的值小于temp
                  arrr[min]=temp;  //临时变量回去
        }

        System.err.println(Arrays.toString(arrr));
    }
}
