package com.github.design.state;


import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:  状态的上文 处理状态的切换逻辑
 * @author: qinxuewu
 * @date: 2019/12/18 11:31
 * @since 1.0.0 
 */
public class VoteManager {
    //持有状体处理对象
    private VoteState state = null;
    //记录用户投票的结果，
    private Map<String,String> mapVote = new HashMap<String,String>();
    //记录用户投票次数
    private Map<String,Integer> mapVoteCount = new HashMap<String,Integer>();

    public  void  setMapVoteCount(Map<String,Integer> mapVoteCount){
        this.mapVoteCount=mapVoteCount;
    }


    /**
     * 获取用户投票结果的Map
     */
    public Map<String, String> getMapVote() {
        return mapVote;
    }



    /**
     * 投票
     * @param user
     * @param item
     */
    public  void  vote(String user,String item){
        // 获取用户的已投票次数
      int oldCount=mapVoteCount.get(user);
      oldCount += 1;
      mapVoteCount.put(user,oldCount); // 累加
        // 判断用户的投票状态 1次=正常 1-5次=重复  5-8=恶意  大于8=黑名单
      if(oldCount == 1){
         state = new NormalVoteState();
      }else if(oldCount>1 && oldCount< 5){
          state=new RepeatVoteState();
      }else if(oldCount>=5 && oldCount<8){
          state=new SpiteVoteState();
      }else if(oldCount > 8){
          state=new BlackVoteState();
      }
      // 然调换状态对象进行相应的操作
        state.vote(user,item,this);
    }
}
