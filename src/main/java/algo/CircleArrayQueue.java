package algo;


/**
 * 功能描述: 素组实现环形队里
 * @author: qinxuewu
 * @date: 2019/10/22 11:22
 * @since 1.0.0
 */
public class CircleArrayQueue {
    /** 队列元素  **/
    private  int []data;
    /** 队列最大容量  **/
    private  int n;
    // 指向第一个元素 即head=0
    private  int head;
    // 指向队里尾巴的下一个元素  初始值为0,空出一个空间做约定
    private  int tail;
    public  CircleArrayQueue(int n){
        this.data=new int[n];
        this.n=n;
        this.head=0;
        this.tail=0;
    }
    /** 判断队列是否为空  **/
    public boolean isEmpty(){
        return head==tail;
    }
    /** 判断队列是否已满 **/
    public boolean isFull(){
        // 取模运算
        // n=5, head=0, tail=4  (tail+1) % n=0  队里已满
        // n=5, head=1, tail=4  (tail+1) % n=0   出队一个，此时队里未满
        return  (tail+1) % n==head;
    }

    /** 入队  队尾入**/
    public void  addQueue(int value){
        if(isFull()){ throw new RuntimeException("队列已满"); }
        data[tail]=value;
        tail=(tail+1) % n; // 取模后移
    }

    public  int size(){
        // n=5, head=1, tail=4
        return (tail+n -head) % n;
    }
    /** 出兑  队头出**/
    public int getQueue(){
        if(isEmpty()){ throw new RuntimeException("队列空"); }
        int valu=data[head];
        head=(head+1) % n;    // 取模后移
        return valu;
    }
}
