package com.github.design.observer;

/**
 * 功能描述:  观察者  实现了update方法
 * @author: qinxuewu
 * @date: 2020/1/22 17:46
 * @since 1.0.0 
 */
public class User  implements  Observer {
    private String name;
    private String message;
    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }
}
