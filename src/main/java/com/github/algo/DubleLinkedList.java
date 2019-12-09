package com.github.algo;


/**
 * 功能描述: 双向链表
 * @author: qinxuewu
 * @date: 2019/10/28 14:33
 * @since 1.0.0
 */
public class DubleLinkedList {
    //  定义一个头节点
    private  DubleNode head=new DubleNode(0,"");
    public DubleNode getHead() {
        return head;
    }

    public  void  list(){
        DubleNode temp=head.next;
        while (temp!=null){
            System.out.println(temp.toString());
            temp=temp.next;

        }
    }

    /**
     * 添加到节点末尾
     * @param newNode
     */
    public void  add(DubleNode newNode){
        // 头节点不能动 通过辅助节点操作
        DubleNode cur=head;
        while (cur.next!=null){
            cur=cur.next;
        }
        // 添加到尾巴
        cur.next=newNode;
        newNode.pre=cur;
    }

    /**
     * (按顺序)添加的指定节点的位置,头节点不能动。
     *  根据编号 找到当前要添加节点的位置
     *
     *          初始化：  1 4 6  newNode=2
     *          temp=4   pre=1;
     *          newNode.pre=pre (1 <-2)
     *          newNode.nex=temp(2->4)
     *          temp.pre=newNode(2<-4)
     *          pre.next=newNode(1->2)
     * @param newNode
     */
    public  void  addIndex(DubleNode newNode){
        DubleNode temp=head;
        // flag 标志添加的编号是否存在，默认为 false
        boolean flag = false;
        while (temp.next!=null){
            if(temp.no > newNode.no){
                // 大于 说明找到了添加位置的节点 temp此时就是
                break;
            }else if (temp.no == newNode.no){
                System.out.println("编号已存在");
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(!flag){
            DubleNode pre=temp.pre;
            newNode.pre=pre;
            newNode.next=temp;
            temp.pre=newNode;
            pre.next=newNode;
        }
    }

    /**
     *  删除指定编号的节点
     *  思路：找到要删除的节点temp,
     *  改变  temp.pre.next=temp.next  temp.next.pre=temp.pre
     * @param no
     */
    public  void  delete(int no){
        if(head.next==null){
            System.out.println("节点为空....");
            return;
        }
        DubleNode temp=head.next;
        while (temp!=null){
            if(temp.no==no){
                temp.pre.next=temp.next;
                // 如果是删除最后的节点 则不能执行这段代码 否则空指针
                if(temp.next!=null){
                    temp.next.pre=temp.pre;
                }
            }
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        DubleLinkedList dubleLinkedList=new DubleLinkedList();
        dubleLinkedList.add(new DubleNode(1,"aaaa"));
        dubleLinkedList.add(new DubleNode(6,"bbbb"));
        dubleLinkedList.add(new DubleNode(2,"bbbb"));
        dubleLinkedList.list();

        System.out.println("删除链表..................");
        dubleLinkedList.delete(2);
        dubleLinkedList.list();

        System.out.println("添加的节点的指定位置");
        dubleLinkedList.addIndex(new DubleNode(2,"222222222222"));
        dubleLinkedList.list();
    }
}

class DubleNode {
    public int no;
    public String name;
    public  DubleNode pre;
    // 指向下一个节点的指针
    public  DubleNode next;
    public DubleNode(int no,String name){
        this.no=no;
        this.name=name;
    }

    @Override
    public String toString() {
        return "DubleNode{" + "no=" + no + ", name='" + name + '\'' + '}';
    }

}
