package problem.SizeOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
Given the root of a binary tree, return the size of the tree. The size of a binary tree is the total number of nodes in the tree.

Examples:
    1
  /   \
 2     3
Input:

Output:  3
Explanation: There are 3 nodes in the given binary tree, so its size is 3.
* */
public class MainActivity {
    public static void main(String[] args) {

        TreeNode treeNode=new TreeNode();
        treeNode.addValue(new Scanner(System.in));

        treeNode.display();

        System.out.println("size of binary tree: "+sizeOfTree(treeNode.root));

        System.out.println("level order traversal:");
        levelOrderTraversal(treeNode.root);

    }

    public static int sizeOfTree(TreeNode.Node node){
        if(node==null)
            return 0;
        return sizeOfTree(node.left) + sizeOfTree(node.right) + 1;

    }

    public static void levelOrderTraversal(TreeNode.Node node) {
        if (node == null)
            return;

        Queue<TreeNode.Node> que = new LinkedList<>();
        que.add(node);

        while (!que.isEmpty()) {
            int size = que.size();

            while (size-- > 0) {
                TreeNode.Node temp = que.poll();
                System.out.print(temp.data + " ");

                if (temp.left != null)
                    que.add(temp.left);

                if (temp.right != null)
                    que.add(temp.right);
            }

            System.out.println();
        }
    }
}
