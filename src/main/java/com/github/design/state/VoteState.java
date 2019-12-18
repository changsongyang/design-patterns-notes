package com.github.design.state;


/**
 * 功能描述: 状态模式- 抽象的状态类
 * @author: qinxuewu
 * @date: 2019/12/18 11:30
 * @since 1.0.0
 */
public interface VoteState {

    /**
     * 处理状态的行为
     * @param user 投票人
     * @param item 投票的项目
     * @param voteManager 投票的上下文管理器 实现对应状态的功能呢的处理
     */
    void vote(String user,String item,VoteManager voteManager);
}
