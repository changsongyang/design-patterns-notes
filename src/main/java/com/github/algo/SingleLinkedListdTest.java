package com.github.algo;

public class SingleLinkedListdTest {

    public static void main(String[] args) {
        SingleLinkedList linkedList=new SingleLinkedList();
        linkedList.add(new Node(1,"aaaa"));
        linkedList.add(new Node(2,"bbbb"));
        linkedList.add(new Node(4,"cccc"));


        SingleLinkedList linkedList2=new SingleLinkedList();
        linkedList2.add(new Node(1,"1111"));
        linkedList2.add(new Node(3,"3333"));

        Node node=linkedList.merge(linkedList.getHead(),linkedList2.getHead());
        System.out.println("合并两个有序链表..............");
        while (node!=null){
            System.out.println(node.toString());
            node=node.next;
        }
//        linkedList.list();
//
//        System.out.println("单链表逆序输出...............");
//        linkedList.reversePrint();

//        System.err.println("反转链表。。。。。。。。。。。");
//        linkedList.reverse();
//        linkedList.list();

//        linkedList.addIndex(new Node(1,"aaaa"));
//        linkedList.addIndex(new Node(4,"bbbb"));
//        linkedList.addIndex(new Node(2,"cccc"));
//        linkedList.list();


//        linkedList.updatenNode(new Node(4,"dddddddddddd"));
//        linkedList.list();
//
//        linkedList.delete(2);
//        linkedList.list();
    }
}
