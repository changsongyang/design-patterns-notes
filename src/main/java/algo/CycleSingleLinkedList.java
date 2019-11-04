package algo;


/**
 * 功能描述: 单向循环链表
 *
 *    遍历：用一个辅助节点curBoy 遍历链表  当curBoy.next=first 则遍历结束
 *
 * @author: qinxuewu
 * @date: 2019/10/30 9:31
 * @since 1.0.0
 */
public class CycleSingleLinkedList {
    private Boy first=null;

    // 构建单向循环链表：让尾节点的next指向首节点
    public void  addBoy(int num){
        if(num<0){ return; }
        Boy cur=null;     //辅助指针用来记录当前节点
        for (int i = 1; i <= num; i++) {
            Boy boy=new Boy(i);
            if(i==1){
                //当为一个时 直接first=cur
                first=boy;
                first.next=first; //构成环
                cur=boy; // 节点移动 指向一个
            }else{
                cur.next=boy;// 添加到当前节点后面
                boy.next=first; //构成环
                cur=boy;
            }
        }
    }

    // 遍历
    public void  showAll(){
        // 用一个辅助节点curBoy 遍历链表  当curBoy.next=first 则遍历结束
        Boy curBoy=first;
        while (true){
            System.out.println(curBoy.no);
            if(curBoy.next==first){
                break;
            }
            curBoy=curBoy.next;
        }
    }

    /**
     *  约瑟夫环报数问题
     *
     *  1 先创建一个辅助变量helper,事先指向链表的最后这个节点
     *          提醒： 首选i让helper和first移动k-1次
     *  2 当开始报数数 让helper和first同时移动m-1次
     *  3 这时就可以将first指向的节点出圈  first=first.next，helper.next=first，、
     *      直到helper.next=first 则表示链表剩下一个节点
     * @param k  从第几个报数
     * @param m   数几下
     * @param nums 总共多少个人
     */
    public void  counBoy(int k,int m,int nums)  {
        if(k< 1 | k >nums){ throw new RuntimeException("参数有误"); }
        // 先创建一个辅助变量helper,
        Boy helper=first;
        while (true){
            // 链表剩下一个节点
            if(helper.next==first){ break; }

            helper=helper.next;             //指向链表的最后这个节点
        }
        // 首选让helper和first移动k-1次
        for (int i = 0; i < k-1; i++) {
            helper=helper.next;
            first=first.next;
        }
        // 当开始报数数 让helper和first同时移动m-1次
        while (true){
            // first指向的节点出圈
            if(helper==first){ break; }
            for (int i = 0; i < m-1; i++) {
                helper=helper.next;
                first=first.next;
            }
            // 这时就可以将first指向的节点出圈
            System.out.println("出圈："+first.no);
            first=first.next;
            helper.next=first;
        }
        System.out.println("最后出圈："+first.no);
    }

    public static void main(String[] args) {
        CycleSingleLinkedList list=new CycleSingleLinkedList();
        list.addBoy(5);
        list.showAll();

        list.counBoy(1,2,5);
    }
}

class  Boy {
    public   int no;
    public Boy next;
    public  Boy(int no){
        this.no=no;
    }
}