package com.github.algo.search;


import java.io.File;

/**
 * 功能描述:  使用递归遍历文件目录以及子目录
 *  函数调用自身，就叫作递归。递归底层其实使用的是栈这种数据结构的原理，把递归操作的步骤存储在栈尾，一直递归到递归的基准位置，也是结束递归的条件，
 *  然后通过出栈的方式回放操作。
 * @author: qinxuewu
 * @date: 2019/10/25 10:04
 * @since 1.0.0
 */
public class RecursiveDir {
    public static void main(String[] args) {
        String path="D:\\ideaWork\\design-patterns-notes\\src\\main\\java";
        File file=new File(path);
        recursive(file);
    }

    public  static  void recursive(File file){
        File[] fs = file.listFiles();
        for (File f:fs){
            if(f.isDirectory()){
                //如果是目录则递归
                System.out.println("目录："+f);
                recursive(f);
            }
            if(f.isFile()){
                // 如果是文件打印输出
                System.out.println("    "+f);
            }
        }

    }
}
