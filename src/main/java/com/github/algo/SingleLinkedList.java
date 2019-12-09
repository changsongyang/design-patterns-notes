package com.github.algo;

import java.util.Stack;

/**
 * 单链表操作
 */
public class SingleLinkedList {
    // 初始一个头节点
    private  Node head=new Node(0,"");

    public Node getHead() {
        return head;
    }

    /**
     * 添加到节点末尾
     * @param newNode
     */
    public void  add(Node newNode){
        // 头节点不能动 通过辅助节点操作
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        // 循环结束 将最后这个节点的 next 指向 新的节点
        temp.next=newNode;

    }

    /**
     * 添加的指定节点的位置,根据编号添加到节点的下一个位置,通过辅助节点操作，  头节点不能动。
     *     找到添加节点的前一个节点temp, 新节点的next指向temp.next. 然后temp.next替换为newNode
     *     newNode.next = temp.next;
     *     temp.next = heroNode;
     * @param newNode
     */
    public  void  addIndex(Node newNode){
        Node temp=head;
        // flag 标志添加的编号是否存在，默认为 false
        boolean flag = false;
        while (temp.next!=null){
                if(temp.next.no > newNode.no){
                    // 大于 说明找到删除节点的前一个节点 temp此时就是
                    break;
                }else if (temp.next.no == newNode.no){
                    System.out.println("编号已存在");
                    flag=true;
                    break;
                }
                temp=temp.next;
        }
        if(!flag){
            newNode.next=temp.next;
            temp.next=newNode;
        }
    }

    /**
     * 通过编号修改节点的信息
     * @param newNode
     */
    public  boolean  updatenNode(Node newNode){
        Node temp=head.next;
        while (temp!=null){
            if(temp.no==newNode.no){
                temp.name=newNode.name;
                    return  true;
            }
            temp=temp.next;
        }
        return  false;
    }

    /**
     * 通过编号删除节点
     * 我们需要一个 temp 辅助节点找到待删除节点的前一个节点
     * 在比较时，是 temp.next.no 和 需要删除的节点的 no 比较
     * @param no
     * @return
     */
    public  boolean delete(int no){
        Node temp=head;
      while (true){
          if(temp.next==null){
              break;
          }
          if(temp.next.no==no){
              //找到了删除节点的前一个节点
              temp.next=temp.next.next;
              return  true;

          }else {
              System.out.println("未找打相关编号的节点");
          }
          temp=temp.next;
      }
      return  false;

    }

    /**
     * 单链表反转：
     *  1 定义一个反转节点 reverseNode=null 作为辅助头节点
     *  2 从头开始遍历原链表，每遍历一个节点就插入reverseNode的最前端，reverseNode.next=node
     *  3 最后原链表head.next=reverseNode.next
     */
    public   void reverse(){
            //没有节点或只有一个节点无需反转 直接返回
            if(head.next==null || head.next.next==null){
                return;
            }
            // 定义一个赋值节点
            Node cur=head.next;
            // 定义一个反转后的节点
            Node reverseNode=new Node(0,"");
            while (cur!=null){
                // 保存当前节点的next
                Node next=cur.next;
                // 将cur的下一个节点指向新链表的最前端
                cur.next=reverseNode.next;
                // 将cur连接到新链表上
                reverseNode.next=cur;
                // cur后移
                cur=next;
            }
            // 原链表指向新链表 完成反转
            head.next=reverseNode.next;
    }

    /**
     * 单链表逆序打印输出： 利用栈的特性或先反转在打印
     */
    public void  reversePrint(){
        Node cur=head.next;
        Stack<Node> stack=new Stack<Node>();
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().toString());
        }
    }

    /**
     * 合并两个有序的单链表 合并后依然有序
     * @param node
     * @param newNode
     * @return
     */
    public Node merge(Node node,Node newNode){
        // 定义一个空节点
        Node head=new Node(0,"");
        Node l1=node.next;
        Node l2=newNode.next;
        Node cur=head;
        while(l1!=null && l2 !=null){
            if(l1.no<=l2.no){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        //任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return head.next;
    }

    public  void  list(){
        Node temp=head.next;
       while (temp!=null){
           System.out.println(temp.toString());
           temp=temp.next;

       }
    }

}




// 定义结点数据结构
class Node {
    // 编号
    public int no;
    public String name;
    // 指向下一个节点的指针
    public  Node next;

    public Node(int no,String name){
        this.no=no;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}