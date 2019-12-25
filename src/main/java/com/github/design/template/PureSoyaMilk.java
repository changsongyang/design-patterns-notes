package com.github.design.template;

/**
 * 制作纯豆浆 不加任何配料
 *
 * @author qinxuewu
 * @create 19/8/31上午10:51
 * @since 1.0.0
 */


public class PureSoyaMilk extends  AbstSoyaMilk {
    @Override
    void addCondiments() {
        //空实现
    }
    @Override
    boolean customerWantCondiments() {
        return false;
    }
}
