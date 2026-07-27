package problem.Simple_BinaryTree;

import java.util.Scanner;

public class BinaryTree {

    private class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    private Node root;

    public void addData(Scanner scanner){
        System.out.println("Enter the root node:");
        int data=scanner.nextInt();
        root=new Node(data);
        addMoreData(scanner,root);
    }
    private void addMoreData(Scanner scanner, Node node){
        System.out.println("want data in left of "+node.data+" true/false");
        boolean left=scanner.nextBoolean();
        if(left){
            System.out.println("enter data");
            int num=scanner.nextInt();
            node.left=new Node(num);
            addMoreData(scanner, root.left);
        }

        System.out.println("want data in right of: "+node.data+" true/false");
        boolean right=scanner.nextBoolean();
        if(right){
            System.out.println("enter data");
            int num=scanner.nextInt();
            node.right=new Node(num);
            addMoreData(scanner, root.right);
        }
    }

    public void display(){
        displayHelp(root);
    }
    private void displayHelp(Node node){
        if(node==null)
            return;
        displayHelp(node.left);
        System.out.println(node.data);
        displayHelp(node.right);
    }

    public void prettyDisplay(){
        prettyDisplayHelp(root,0);
    }
    private void prettyDisplayHelp(Node node, int level){
        if(node==null)
            return;

        prettyDisplayHelp(node.right,level+1);

        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("\t\t");

            System.out.println("|-------->"+node.data);
        } else {
            System.out.println(node.data);
        }

        prettyDisplayHelp(node.left,level+1);
    }

}
