package problem.BalancedBinaryTree;

public class BiTreeNode {

    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public Node root = null;

    public void addNode(int data) {
        root = addNodeHelper(data, root);
    }
    private Node addNodeHelper(int data, Node node) {
        if (node == null)
            return new Node(data);

        if (data < node.data)
            node.left = addNodeHelper(data, node.left);
        else if (data > node.data)
            node.right = addNodeHelper(data, node.right);

        return node;
    }
}