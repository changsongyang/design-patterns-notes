package com.github.design.patterns.prototype;

/**
 * 克隆羊
 * @author qxw
 * @version 1.00
 * @time  20/8/2019 下午 1:59
 */
public class Sheep  implements  Cloneable{

    private String name;
    private int age;
    private String color;
    private String address="蒙古羊";

    public Sheep  friend; // 是对象 克隆时会自动处理， 默认浅拷贝

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Sheep getFriend() {
        return friend;
    }

    public void setFriend(Sheep friend) {
        this.friend = friend;
    }

    public Sheep(String name, int age, String color) {
        super();
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", address='" + address  +
                '}';
    }

    @Override
    protected Object clone()  {
            Sheep sheep=null;
            try {
                sheep=(Sheep)super.clone();

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return sheep;
    }
}
