package com.github.algo;

import com.github.algo.Times;

/**
 * 裴波那契数列
 *
 * @author qinxuewu
 * @create 20/2/2下午8:13
 * @since 1.0.0
 */


public class Test {


    /**
     *
     *  0 1 1 2 3 5 8
     * 递归解法   数字越大  速度越慢 会栈溢出
     * 前两个数之和 等于第三个数
     * @param n
     * @return
     */
    public  static  int fip(int n){
        if(n<=1){
            return  n;
        }
        return  fip(n-1)+fip(n-2);
    }

    public  static  int fip2(int n){
        if(n<=1){
            return  n;
        }
        int one=0;
        int two=1;
        for (int i = 0; i <n-1 ; i++) {
                int sum=one+two;
                one=two;
                two=sum;
        }

        return  two;

    }


    public static void main(String[] args) {
        Times.test("fip", ()-> System.out.println(fip(35)) );


        Times.test("fip2",()-> System.out.println(fip2(35)) );
    }
}
