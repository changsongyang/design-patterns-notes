package com.github.design.state;


import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: 状态模式 测试
 * @author: qinxuewu
 * @date: 2019/12/18 14:27
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        VoteManager voteManager=new VoteManager();
        // 初始化用户信息
        Map<String,Integer> map=new HashMap<>();
        map.put("qxw",0);
        voteManager.setMapVoteCount(map);
        for (int i = 0; i <9 ; i++) {
            voteManager.vote("qxw","A");
        }
    }
}
