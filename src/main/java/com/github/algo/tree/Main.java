package com.github.algo.tree;

import com.github.algo.tree.printer.BinaryTrees;

/**
 * 〈〉
 *
 * @author qinxuewu
 * @create 20/2/19下午1:55
 * @since 1.0.0
 */


public class Main {

    public static void main(String[] args) {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);

        bst.levelOrder(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 9 ? true : false;
            }
        });

        System.out.println("--------");
        bst.inOrder(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 4 ? true : false;
            }

        });

//        BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
//        for (int i = 0; i < data.length; i++) {
//            bst1.add(new Person(data[i]));
//        }
//        BinaryTrees.println(bst1);





         System.out.println("----------------------------");

        // 前序遍历
//        bst1.preorderTraversal();
//        // 中序遍历
//        bst1.inorderTraversal();
//        // 后序遍历
//        bst1.postorderTraversal();
//        // 层序遍历
//        bst1.levelOrderTraversal();

    }
}
