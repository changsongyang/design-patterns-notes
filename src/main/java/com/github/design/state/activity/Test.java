package com.github.design.state.activity;
public class Test {

    public static void main(String[] args) {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);
        StateHandler stateHandler = new StateHandler();
        Result result = stateHandler.open(activityId, Status.Editing);

         System.out.println("测试结果(编辑中的活动 开始提审~~):"+ result.toString());


         System.out.println("活动状态： "+ActivityService.queryActivityInfo(activityId).getStatus().toString());
    }

}
