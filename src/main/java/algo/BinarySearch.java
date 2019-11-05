package algo;


/**
 * 功能描述: 二分查找  折搬查找  必须数组有序
 * @author: qinxuewu
 * @date: 2019/11/4 18:03
 * @since 1.0.0
 */
public class BinarySearch {

    public static void main(String[] args) {
            int arrays[]={1,3,4,5,6,8,8,8,11,18};
            int k=8;
           int index= binarySearch5(arrays,k);
           System.err.println("最后一个小于"+k+"的元素下标是："+index+", value="+arrays[index]);
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

}
