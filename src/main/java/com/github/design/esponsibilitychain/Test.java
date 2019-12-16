package com.github.design.esponsibilitychain;

/**
 * 责任链模式 测试
 *
 * @author qinxuewu
 * @create 19/12/16下午9:03
 * @since 1.0.0
 */


public class Test {
    public static void main(String[] args) {
        // 创建一个请求
        Request request=new Request(1,100000,1);

        // 创建审批人  构造成一个责任链

        DirectorApprover directorApprover=new DirectorApprover("主任");
        DeanApprover deanApprover=new DeanApprover("院长");

        PrincipalApprover principalApprover=new PrincipalApprover("校长");

        // 将各个级别的审批人下一个设置  构成环形链表的结构， 也可以构造成一个单列表  但是 必须每次都第一个处理人开始
        directorApprover.setApprover(deanApprover);
        deanApprover.setApprover(principalApprover);
        principalApprover.setApprover(directorApprover);



        //  执行方法处理
        deanApprover.process(request);


    }
}
