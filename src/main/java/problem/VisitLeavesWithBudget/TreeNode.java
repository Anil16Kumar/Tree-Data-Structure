package problem.VisitLeavesWithBudget;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }

    public Node root;

    public void addData(int data){
        root=addDataHelper(data, root);
    }
    private Node addDataHelper(int data, Node node){
        if(node==null)
            return new Node(data);

        if(node.data>data)
            node.left=addDataHelper(data, node.left);
        else if(node.data<data)
            node.right=addDataHelper(data, node.right);
        return node;
    }

    public void deleteData(int data){
        root=deleteDataHelper(data, root);
    }
    private Node deleteDataHelper(int data, Node node){
        if(node==null){
            System.out.println("value node found inside the tree");
            return node;
        }

        if(node.data>data)
            node.left=deleteDataHelper(data, node.left);
        else if(node.data<data)
            node.right=deleteDataHelper(data, node.right);
        else{
            if(node.left==null && node.right==null)
                return null;
            if(node.left==null)
                return node.right;
            if(node.right==null)
                return node.left;

            Node successer=findMinimum(node.right);
            node.data=successer.data;
            node.right=deleteDataHelper(successer.data, node.right);
        }
        return  node;
    }
    private Node findMinimum(Node node){
        while (node.left!=null)
            node=node.left;
        return node;
    }

    public void display(){
        displayHelper(root,0);
    }
    private void displayHelper(Node node, int level){
        if(node==null)
            return;

        displayHelper(node.right, level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("\t\t");
            System.out.println("|------>"+node.data);
        } else {
            System.out.println(node.data);
        }
        displayHelper(node.left, level+1);
    }

    public void rootToLeaf(){
        rootToLeftHelper(root, new ArrayList<Integer>());
    }
    private void rootToLeftHelper(Node node, List<Integer> lst){
        if(node==null)
            return;

        lst.add(node.data);

        if(node.left==null && node.right==null)
            System.out.println(lst);
        else{
            rootToLeftHelper(node.left,lst);
            rootToLeftHelper(node.right,lst);
        }
        lst.removeLast();
    }

}
