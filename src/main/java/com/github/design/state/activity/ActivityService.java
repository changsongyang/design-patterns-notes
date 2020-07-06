package com.github.design.state.activity;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



/**
 * 功能描述: 活动服务方法
 * @date: 2020/7/6 9:27
 * @since 1.0.0
 */
public class ActivityService {

    private static Map<String, Enum<Status>> statusMap = new ConcurrentHashMap<String, Enum<Status>>();

    /**
     * 初始化活动信息  一般查数据库获取
     * @param activityId
     * @param status
     */
    public static void init(String activityId, Enum<Status> status) {
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("早起学习打卡领奖活动");
        activityInfo.setStatus(status);
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        // 每个活动的状态保存map中
        statusMap.put(activityId, status);
    }

    /**
     * 查询活动信息
     * @param activityId 活动ID
     * @return 查询结果
     */
    public static ActivityInfo queryActivityInfo(String activityId) {
        // 模拟查询活动信息
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("早起学习打卡领奖活动");
        //获取活动ID的状态
        activityInfo.setStatus(statusMap.get(activityId));
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        return activityInfo;
    }

    /**
     * 查询活动状态
     *
     * @param activityId 活动ID
     * @return 查询结果
     */
    public static Enum<Status> queryActivityStatus(String activityId) {
        return statusMap.get(activityId);
    }


    /**
     * 执行状态变更
     *
     * @param activityId   活动ID
     * @param beforeStatus 变更前状态
     * @param afterStatus  变更后状态 b
     */
    public static synchronized void execStatus(String activityId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {

        if (!beforeStatus.equals(statusMap.get(activityId))){
            return;
        }
        // 更新活动ID的状态
        statusMap.put(activityId, afterStatus);
    }

}
