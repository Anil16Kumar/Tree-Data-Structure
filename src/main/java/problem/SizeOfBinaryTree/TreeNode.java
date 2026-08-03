package problem.SizeOfBinaryTree;

import java.util.Scanner;

public class TreeNode {

    public class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    public Node root;

    public void addValue(Scanner scanner){
        System.out.println("enter the root node:");
        int val=scanner.nextInt();
        root=new Node(val);

        addMoreValue(root, scanner);
    }
    private void addMoreValue(Node node, Scanner scanner){
        System.out.println("want data in left :"+node.data+" ? true/false");
        boolean left=scanner.nextBoolean();
        if(left){
            System.out.println("enter the value:");
            int val=scanner.nextInt();
            node.left=new Node(val);
            addMoreValue(node.left,scanner);
        }

        System.out.println("want data in right :"+node.data+" ? true/false");
        boolean right=scanner.nextBoolean();
        if(right){
            System.out.println("enter the value:");
            int val=scanner.nextInt();
            node.right=new Node(val);
            addMoreValue(node.right, scanner);
        }
    }

    public void display(){
        displayHelp(root,0);
    }
    private void displayHelp(Node node, int level){
        if(node==null){
            return;
        }

        displayHelp(node.right, level+1);

        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("\t\t");
            System.out.println("|------>"+node.data);
        } else {
            System.out.println(node.data);
        }

        displayHelp(node.left, level+1);
    }

}
