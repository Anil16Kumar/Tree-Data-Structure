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

    public Node root;

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

    public void deleteNode(int data){
        root=deleteNodeHelper(root, data);
    }
    private Node deleteNodeHelper(Node node, int data){
        if(node==null){
            System.out.println("node not found");
            return node;
        }
        if(node.data<data){
            node.right=deleteNodeHelper(node.right, data);
        } else if(node.data>data){
            node.left=deleteNodeHelper(node.left, data);
        } else {
          if(node.left==null && node.right==null)
              return null;
          if(node.left==null)
              return node.right;
          if(node.right==null)
              return node.left;
          Node successerNode=findMinimum(node.right);
          node.data=successerNode.data;
          node.right=deleteNodeHelper(node.right, successerNode.data);
        }
        return node;
    }
    private Node findMinimum(Node node){
        while(node.left!=null)
            node=node.left;
        return node;
    }

    public void display(){
        dislayHelper(root, 0);
    }
    private void dislayHelper(Node node, int level){
        if(node==null)
            return;

        dislayHelper(node.right, level+1);

        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("\t\t");
            System.out.println("|------>"+node.data);
        } else {
            System.out.println(node.data);
        }

        dislayHelper(node.left, level+1);
    }

}