package com.github.design.state;


/**
 * 功能描述:  状态模式- 重复投票状态的处理类
 * @author: qinxuewu
 * @date: 2019/12/18 11:35
 * @since 1.0.0
 */
public class RepeatVoteState implements  VoteState {
    @Override
    public void vote(String user, String item, VoteManager voteManager) {
        //重复投票，暂时不做处理
        System.out.println("请不要重复投票");
    }
}
