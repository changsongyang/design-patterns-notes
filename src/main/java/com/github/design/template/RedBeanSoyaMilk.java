package com.github.design.template;

/**
 * 制作红豆豆浆的模板类
 *
 * @author qinxuewu
 * @create 19/8/31上午10:42
 * @since 1.0.0
 */


public class RedBeanSoyaMilk extends  AbstSoyaMilk {

    @Override
    void addCondiments() {
        System.out.println(" 加入上好的红豆 ");
    }
}
