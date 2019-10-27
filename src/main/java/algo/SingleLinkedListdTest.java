package algo;

public class SingleLinkedListdTest {

    public static void main(String[] args) {
        SingleLinkedList linkedList=new SingleLinkedList();
//        linkedList.add(new Node(1,"aaaa"));
//        linkedList.add(new Node(4,"bbbb"));
//        linkedList.add(new Node(2,"cccc"));
//        linkedList.list();

        linkedList.addIndex(new Node(1,"aaaa"));
        linkedList.addIndex(new Node(4,"bbbb"));
        linkedList.addIndex(new Node(2,"cccc"));
        linkedList.list();


        linkedList.updatenNode(new Node(4,"dddddddddddd"));
        linkedList.list();

        linkedList.delete(2);
        linkedList.list();

    }
}
