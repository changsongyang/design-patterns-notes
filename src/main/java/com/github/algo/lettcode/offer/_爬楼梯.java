package com.github.algo.lettcode.offer;


/**
 假设你现在正在爬楼梯，楼梯有 n 级。每次你只能爬 1级或者 2级，那么你有多少种方法爬到楼梯的顶部？
 递归解法：f(n)=f(n-1)+f(n-2);
 */
public class _爬楼梯 {

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib04(5));
    }

    /**
     * 递归 推导f(n)=f(n-1)+f(n-2);
     * @param n
     * @return
     */
    public  static int fib(int n){
        if(n<=2) return  n;
        return  fib(n-1)+fib(n-2);
    }
    // 4.动态规划法 (利用数组来存储)
    public static int fib04(int n) {
        if (n == 0) return 1;
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
