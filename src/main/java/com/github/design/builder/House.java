package com.github.design.builder;


/**
 * 功能描述:  建造者模式
 *   盖房项目需求
 *      需要建房子：这一过程为打桩、 砌墙、封顶
 *      房子有各种各样的，比如普通房，高楼，别墅，各种房子的过程虽然一样，但是
 * 要求不要相同的
 *
 * @author: qinxuewu
 * @date: 2019/12/18 10:54
 * @since 1.0.0
 */
public class House {
    private String baise;
    private String wall;
    private String roofed;
    public String getBaise() {
        return baise;
    }
    public void setBaise(String baise) {
        this.baise = baise;
    }
    public String getWall() {
        return wall;
    }
    public void setWall(String wall) {
        this.wall = wall;
    }
    public String getRoofed() {
        return roofed;
    }
    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}
