package com.github.design.adapter.interfaceadapter;


/**
 * 功能描述: TF卡实现类
 * @author: qinxuewu
 * @date: 2019/12/25 10:12
 * @since 1.0.0
 */
public class TFCardImpl  implements  TFCard{
    @Override
    public String readTF() {
        return "读取TF卡.....";
    }

    @Override
    public int writeTF(String msg) {
        System.out.println("写入TF卡..."+msg);
        return 1;
    }
}
