package com.github.builder;

/**
 *  盖房项目需求： 需要建房子：这一过程为打桩、 砌墙、封顶
 *          房子有各种各样的，比如普通房，高楼，别墅，各种房子的过程虽然一样，但是要求不要相同的
 *
 *
 * 抽象的建造者
 * @author qxw
 * @version 1.00
 * @time  20/8/2019 下午 2:48
 */
public abstract class HouseBuilder {
    protected  House house=new House();

    //将建造的流程写好, 抽象的方法
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    //建造房子好， 将产品(房子) 返回
    public House buildHouse() {
        return house;
    }

}
