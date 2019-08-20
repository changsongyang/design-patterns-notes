package com.github.single.dcl;

/**
 *
 * DCL 双重锁检查懒汉式 单列模式
 * @author qxw
 * @version 1.00
 * @time  19/8/2019 下午 3:57
 */
public class SingleDcl {
    private  SingleDcl(){}
    private  volatile  static    SingleDcl single;
    public  SingleDcl getSingle(){
        if (single==null){
            synchronized(SingleDcl.class){
                if (single==null){
                    single=new SingleDcl();
                }
            }
        }
        return  single;
    }
}
