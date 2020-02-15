package com.github.algo.search;


import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 二分查找  折搬查找  必须数组有序
 * @author: qinxuewu
 * @date: 2019/11/4 18:03
 * @since 1.0.0
 */
public class BinarySearch {

    public static void main(String[] args) {
//            int arrays[]={1,3,4,5,6,8,8,8,11,18};
//            int k=8;
//           int index= binarySearch5(arrays,k);
//           System.err.println("最后一个小于"+k+"的元素下标是："+index+", value="+arrays[index]);

           int []arr={1,2,3,3,3,4,5,8};
          List<Integer> list=binarySearch6(arr,0,arr.length-1,3);

    }


    /**
     * 常规二分查找
     * @param arrays
     */
    private static   int  binarySearch1(int [] arrays,int k){
        int left=0;
        int right=arrays.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(arrays[mid]>k){
                right=mid-1;
            }else if(arrays[mid]<k){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return  -1;
    }

    /**
     * 二分查找法变体1 查找有序数组中第一个值等于给定值的元素  数据有重复元素
     * @param arrays
     * @param k
     * @return
     */
    private static   int  binarySearch2(int [] arrays,int k){
        int left=0;
        int right=arrays.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(arrays[mid]>k){
                right=mid-1;
            }else if(arrays[mid]<k){
                left=mid+1;
            }else{
                if(mid==0 || (arrays[mid-1]!=k)){
                    return mid;
                }else{
                    right=mid-1;
                }
            }
        }
        return  -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     *  当arr[mid]==k时，查找最后一个和第一个正好相反 判断mid是否等于数组长度，如果是则表明是最后一个元素的，
     *   如果不是则判断arr[mid+1]位置的元素是否不等于K,如果是则说明已经是找到匹配最后一个元素，否则`left=mid+1`
     * @param arrays
     * @param k
     * @return
     */
    private static   int  binarySearch3(int [] arrays,int k){
        int left=0;
        int right=arrays.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(arrays[mid]>k){
                right=mid-1;
            }else if(arrays[mid]<k){
                left=mid+1;
            }else{
                if(mid==arrays.length-1 || (arrays[mid+1]!=k)){
                    return mid;
                }else{
                    left=mid+1;
                }
            }
        }
        return  -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    private static   int  binarySearch4(int [] arrays,int k){
        int left=0;
        int right=arrays.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(arrays[mid] >= k){
                if(arrays[mid-1]<k){
                    return mid;
                }
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return  -1;
    }

    /**
     * 变体四：查找最后一个小于等于给定值的元素
     * @param arrays
     * @param k
     * @return
     */
    private static   int  binarySearch5(int [] arrays,int k){
        int left=0;
        int right=arrays.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(arrays[mid] >k){
                right=mid-1;
            }else{
                // 小于等于的条件
                if(arrays[mid+1]>k){
                    return  mid;
                }
                left=mid+1;
            }
        }
        return  -1;
    }

    /**
     * 二分查找变体； 查找指定值的在数组中的所有的下标位置
     * @return
     */
    private static List<Integer> binarySearch6(int [] arr,int left,int right,int k){
            // 递归结束条件 当左指针大于右指针 说明 已经到遍历完整个数组
            if(left > right){
                return  new ArrayList<Integer>();
            }
           int mid=left+(right-left)/2;
            if(arr[mid] < k){
                // 中间值  小于要查找的值 说明指定的值在left到mid-1区间
                // 向左边递归查找
                return  binarySearch6(arr,left,mid-1,k);
            }else if (arr[mid] >k ){
                return  binarySearch6(arr,mid+1,right,k);
            }else{
                // 相等 找到了
                List<Integer> list=new ArrayList<Integer>();
                list.add(mid);
                // 继续循环遍历 分别想mid左边和右边查找
                int temp=mid-1;   // 左边
                while (true){
                    //退出条件
                    if(temp < 0 || arr[temp] !=k){
                        break;
                    }
                    list.add(temp);
                    temp=temp-1;             //左移
                }
                temp=mid+1;
                while (true){
                    //退出条件
                    if(temp > arr.length-1 || arr[temp] !=k){
                        break;
                    }
                    list.add(temp);
                    temp=temp+1;             //右移
                }
                return  list;
            }
    }

}
