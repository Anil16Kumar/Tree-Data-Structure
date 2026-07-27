package problem.Invert_Binary_Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
                Before Invert                    After Invert

                     4                               4
                   /   \                           /   \
                  2     7                         7     2
                 / \   / \                       / \   / \
                1   3 6   9                     9   6 3   1

        Invert Binary Tree:
        - Swap the left and right child of every node.
        - Repeat recursively for all nodes in the tree.

        Example:
            Node 4: left(2) <-> right(7)
            Node 2: left(1) <-> right(3)
            Node 7: left(6) <-> right(9)

        Result:
            Every node has its left and right children swapped.
*/

public class MainActivity {
    public static void main(String[] args) {
        BtreeNode node=new BtreeNode();
        node.addData(new Scanner(System.in));

        node.levelOrderTraversal();

        node.display();
        node.root=invertTree(node.root);
        node.display();

    }

    public static BtreeNode.Node invertTree(BtreeNode.Node node){
        if(node==null)
            return null;

        BtreeNode.Node temp=node.left;
        node.left=node.right;
        node.right=temp;

        invertTree(node.left);
        invertTree(node.right);

        return node;

    }
}
