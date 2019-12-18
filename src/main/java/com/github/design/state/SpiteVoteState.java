package com.github.design.state;


import org.springframework.util.StringUtils;

/**
 * 功能描述:  状态模式- 恶意投票状态的处理类
 * @author: qinxuewu
 * @date: 2019/12/18 11:37
 * @since 1.0.0
 */
public class SpiteVoteState implements  VoteState {
    @Override
    public void vote(String user, String item, VoteManager voteManager) {
        // 恶意投票，取消用户的投票资格，并取消投票记录
        String info=voteManager.getMapVote().get(user);
        if(!StringUtils.isEmpty(info)){
            voteManager.getMapVote().remove(user);
        }
        System.out.println("你有恶意刷屏行为，取消投票资格");
    }
}
