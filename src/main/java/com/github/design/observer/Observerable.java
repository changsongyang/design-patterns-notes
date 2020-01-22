package com.github.design.observer;

/**
 * 功能描述:
 *      抽象被观察者接口  , 声明了添加、删除、通知观察者方法
 * @author: qinxuewu
 * @date: 2020/1/22 17:36
 * @since 1.0.0
 */
public interface Observerable {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
