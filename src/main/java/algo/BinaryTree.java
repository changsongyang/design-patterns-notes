package algo;


/**
 * 功能描述: 二叉树的 前序遍历 中序遍历 后续遍历
 *  区别：根节点的遍历顺序
 * @author: qinxuewu
 * @date: 2019/11/19 11:05
 * @since 1.0.0
 */
public class BinaryTree {


    public static void main(String[] args) {
        TreeNode root=new TreeNode(1,"A");

        TreeNode left1=new TreeNode(2,"B");
        TreeNode righr1=new TreeNode(5,"C");
        root.setLeft(left1);
        root.setRight(righr1);

        TreeNode left2=new TreeNode(3,"D");
        TreeNode righr2=new TreeNode(4,"E");
        left1.setLeft(left2);
        left1.setRight(righr2);


        TreeNode left3=new TreeNode(6,"F");
        TreeNode righr3=new TreeNode(7,"G");
        righr1.setLeft(left3);
        righr1.setRight(righr3);


        System.out.println("前序遍历............ABDECFG.....");
        preOrder(root);    // ABDECFG

        System.out.println("中序遍历...........DBEAFCG......");
        inorderOrder(root);

        System.out.println("后序遍历..........DEBFGCA.......");
        postOrder(root);

    }

    /**
     * 前序遍历: 根节点>左节点>右节点
     */
    public static   void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.toString());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    /**
     * 中: 左节点>根节点》右节点
     */
    public static   void inorderOrder(TreeNode root){
        if(root==null){
            return;
        }
        inorderOrder(root.getLeft());
        System.out.println(root.toString());
        inorderOrder(root.getRight());
    }

    /**
     * 后续遍历: 左节点>右节点>根节点
     */
    public static   void postOrder(TreeNode root){
        if(root==null){
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.toString());
    }

}


