package algo;


/**
 * 功能描述: 二分查找  折搬查找  必须数组有序
 * @author: qinxuewu
 * @date: 2019/11/4 18:03
 * @since 1.0.0
 */
public class BinarySearch {

    public static void main(String[] args) {
            int arrays[]={1,3,5,7,9};
            int k=3;
           int index= test1(arrays,k);
           System.err.println(index);
    }


    /**
     * 常规二分查找
     * @param arrays
     */
    private static   int  test1(int [] arrays,int k){
        int left=0;
        int right=arrays.length-1;
        while (left<=right){
//            int mid=left+(right-left)/2;
            int mid=left+(right-left)>>1;
            if(arrays[mid]>k){
                right=mid-1;
            }else if(arrays[mid]<k){
                left=mid+1;
            }else{
                return  mid;
            }
        }
        return  -1;
    }
}
