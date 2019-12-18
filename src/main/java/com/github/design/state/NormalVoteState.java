package com.github.design.state;


/**
 * 功能描述:  状态模式- 正常投票状态的处理类
 * @author: qinxuewu
 * @date: 2019/12/18 11:33
 * @since 1.0.0
 */
public class NormalVoteState implements  VoteState {
    @Override
    public void vote(String user, String item, VoteManager voteManager) {
        //正常投票，记录到投票记录中
         voteManager.getMapVote().put(user,item);
    }
}
