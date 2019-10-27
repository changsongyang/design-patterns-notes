package com.github.template;

/**
 *  模板方法模式
 *
 * @author qinxuewu
 * @create 19/8/31上午10:44
 * @since 1.0.0
 */


public class TemplateTest {

    public static void main(String[] args) {

        System.out.println("制作红豆豆浆....");
        AbstSoyaMilk redBeanSoyaMilk=new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();


        System.out.println("制作花生豆浆....");
        AbstSoyaMilk peanutSoyaMilk=new RedBeanSoyaMilk();
        peanutSoyaMilk.make();


        System.out.println("制作纯豆浆....");
        AbstSoyaMilk pureSoyaMilk=new PureSoyaMilk();
        pureSoyaMilk.make();
    }
}
