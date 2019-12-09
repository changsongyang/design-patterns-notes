package com.github.algo;

/**
 *  简单的HashTable的实现
 *
 *  有一个公司,当有新的员工来报道时,要求将该员工的信息加入(id,性别,年龄,名字,住址..),当输入该员工的 id 时,
 * 要求查找到该员工的 所有信息.
 *
 * @author qinxuewu
 * @create 19/11/17下午4:27
 * @since 1.0.0
 */


public class MyHashTable {

    public static void main(String[] args) {
        MyHashTable hashTable=new MyHashTable(5);
        hashTable.addEmp(new Emp(1,"aaaa"));
        hashTable.addEmp(new Emp(2,"bbbbbb"));

        hashTable.lists();
    }

    //  链表数组
    private  EmpLikendList[] likendLists;

    private  int szie;
    public  MyHashTable(int size){
        this.szie=size;
        // 初始化固定大小的hashTable
        likendLists=new EmpLikendList[size];
        for (int i = 0; i < size; i++) {
            // 每个数组中初始化链表
            likendLists[i]=new EmpLikendList();
        }
    }


    // 散列函数  取模 找到对应的数组中的链表
    public  int hashInt(int id){
        return  id % szie;
    }

    public  void  lists(){
        for (int i = 0; i < szie; i++) {
            likendLists[i].list(i);
        }
    }
    public  void  addEmp(Emp emp){
        // 通过散列函数找到链表
        int index=hashInt(emp.id);
        // 添加到链表中
        likendLists[index].add(emp);
    }


}

// 相同的id hash值存入同一个链表中
class  EmpLikendList{
    // 头指针 存放第一个元素
    public  Emp head;

    public  void  add(Emp emp){
        if(head==null){
            head=emp;
            return;
        }

        Emp temp=head;
        while (true){
            if(temp.next==null){
                break;  // 已经到链表最后了
            }
            // 否则找到链表最后的元素
            temp=temp.next;
        }
        // 退出时， 添加元素到链表末尾
        temp.next=emp;
    }


    public void  list(int no){
        if(head==null){
            System.out.println("第 "+(no+1)+" 链表为空");
            return;
        }
        System.out.println("第 "+(no+1)+" 链表的信息为");
        Emp temp=head;
        while (temp.next!=null){
            System.out.printf(" => id=%d name=%s\t", temp.id, temp.name);
            temp=temp.next;
        }
    }

}

class  Emp {
    public int id;
    public String name;
    public  Emp next;
    public  Emp(int id,String name){
        this.id=id;
        this.name=name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }
}
