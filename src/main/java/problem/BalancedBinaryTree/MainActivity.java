package problem.BalancedBinaryTree;

import problem.Simple_BinaryTree.BinaryTree;

public class MainActivity {
    public static void main(String[] args) {
        BiTreeNode biTreeNode=new BiTreeNode();
        biTreeNode.addNode(23);
        biTreeNode.addNode(22);
        biTreeNode.addNode(3);
        biTreeNode.addNode(202);
        biTreeNode.addNode(54);
        biTreeNode.addNode(87);
        biTreeNode.addNode(90);
        biTreeNode.addNode(342);

        biTreeNode.display();

    }
}
