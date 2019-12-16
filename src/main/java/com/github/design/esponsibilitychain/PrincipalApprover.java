package com.github.design.esponsibilitychain;

/**
 * 责任链模式：如果金额小于等于10000,由院长审批
 * 校长审批
 * @author qinxuewu
 * @create 19/12/16下午8:59
 * @since 1.0.0
 */


public class PrincipalApprover extends  AbstractApprover{

    public PrincipalApprover(String name){
        super(name);
    }

    @Override
    public void process(Request request) {
        if(request.getPrice()>10000){
            // 自己处理
            System.out.println(" 请求编号 id= " + request.getId() + " 被 " + this.name + " 处理");
        }else {
            // 下一个责任链处理者
            approver.process(request);
        }
    }
}
