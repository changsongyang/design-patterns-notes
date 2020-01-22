package com.github.design.observer;


/**
 * 功能描述:  https://www.cnblogs.com/luohanguo/p/7825656.html
 * @author: qinxuewu
 * @date: 2020/1/22 17:52
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        // 创建一个被观察者
        WechatServer server = new WechatServer();

        // 首先注册了三个用户
        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        // 添加到被观察者集合中
        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);

        // 发一条消息到， 被观察者都会收到这条消息的通知
        server.setInfomation("JAVA是世界上最好用的语言！");
        System.out.println("----------------------------------------------");

        //  userZhang用户 取消通知的订阅
        server.removeObserver(userZhang);
        server.setInfomation("Go是世界上最好用的语言！");
    }
}
