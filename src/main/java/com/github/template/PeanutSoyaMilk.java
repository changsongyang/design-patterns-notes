package com.github.template;

/**
 *  制作花生豆浆的模板类
 *
 * @author qinxuewu
 * @create 19/8/31上午10:42
 * @since 1.0.0
 */


public class PeanutSoyaMilk extends  AbstSoyaMilk {

    @Override
    void addCondiments() {
        System.out.println(" 加入上好的花生 ");
    }
}
