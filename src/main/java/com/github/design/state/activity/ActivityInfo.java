package com.github.design.state.activity;

import lombok.Data;

import java.util.Date;


/**
 * 功能描述:  模拟营销活动审核状态流转场景(一个活动的上线是多个层级审核上线的)
 * @date: 2020/7/6 9:31
 * @since 1.0.0
 */
@Data
public class ActivityInfo {


    private String activityId;    // 活动ID
    private String activityName;  // 活动名称
    private Enum<Status> status;  // 活动状态
    private Date beginTime;       // 开始时间
    private Date endTime;         // 结束时间
}
