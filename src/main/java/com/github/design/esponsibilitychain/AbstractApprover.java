package com.github.design.esponsibilitychain;

/**
 *  责任链模式：抽象的处理者， 审批人
 *
 * @author qinxuewu
 * @create 19/12/16下午8:42
 * @since 1.0.0
 */


public  abstract  class AbstractApprover {
    AbstractApprover approver;   //下一个处理者
    String name; // 名字

    public  AbstractApprover(String name){
        this.name=name;
    }


    /**
     *
     * 设置职责链中的下一个处理者
     * @param approver
     */
    public  void  setApprover(AbstractApprover approver){
        this.approver=approver;
    }


    /**
     * 处理审批请求的方法,得到一个请求,处理是子类完成,因此该方法做成抽象
     */
    public  abstract  void  process(Request request);

}
