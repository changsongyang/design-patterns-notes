package com.github.design.state;


/**
 * 功能描述: 状态模式- 恶意投票状态的处理类
 * @author: qinxuewu
 * @date: 2019/12/18 11:39
 * @since 1.0.0
 */
public class BlackVoteState implements  VoteState {
    @Override
    public void vote(String user, String item, VoteManager voteManager) {
        //记录黑名单中，禁止登录系统
        System.out.println("进入黑名单，将禁止登录和使用本系统");
    }
}
