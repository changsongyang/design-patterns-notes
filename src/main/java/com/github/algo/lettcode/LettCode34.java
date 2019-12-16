package com.github.algo.lettcode;

import java.util.Arrays;

public class LettCode34 {

    public static void main(String[] args) {
        int[]  nums ={1,3,4,5,6,8,8,8,11,18};
        int target = 7;


//        int[] result=searchRange(nums,target);
        System.out.println(binarySearch2(nums,target));
    }

    public static int[] searchRange(int[] arrays, int k) {
        int left=0;
        int start=-1;
        int right=arrays.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(arrays[mid]>k){
                right=mid-1;
            }else if(arrays[mid]<k){
                left=mid+1;
            }else{
                if(mid==0 || (arrays[mid-1]!=k)){
                    start=mid;
                    break;
                }else{
                    right=mid-1;
                }
            }
        }

        left=0;
        right=arrays.length-1;
        int end=-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(arrays[mid]>k){
                right=mid-1;
            }else if(arrays[mid]<k){
                left=mid+1;
            }else{
                if(mid==arrays.length-1 || (arrays[mid+1]!=k)){
                    end=mid;
                    break;
                }else{
                    left=mid+1;
                }
            }
        }
        return new int[]{start,end};
    }



    public static int[]  binarySearch3(int[] arrays, int k){
         int l=0;
         int r=arrays.length;
         int [] result={-1,-1};
         while (l<r){
             int mid = l + (r-l) /2;
             if(arrays[mid]>=k){
                 r=mid;
             }else{
                 l=mid+1;
             }
         }
        if(arrays[l]!=k) {return result;}
        result[0]=l;

         l=0;
         r=arrays.length;
        while (l<r){
            int mid = l + (r-l) /2;
            if(arrays[mid]<=k){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        result[1]=l-1;
        return  result;
    }

    /**
     * 查找第一个等于给定的值
     * @param arrays
     * @param k
     * @return
     */
    private static   int  binarySearch2(int [] arrays,int k){
            int l=0;
            int r=arrays.length;
            while (l<r){
                int mid=l+(r-l)/2;
                if(arrays[mid]<=k){
                    l=mid+1;
                }else{
                    r=mid;
                }
                System.out.println("l:"+l+"  r"+r);
            }
            return  l;
    }
}
