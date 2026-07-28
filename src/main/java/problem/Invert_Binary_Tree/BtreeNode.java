package problem.Invert_Binary_Tree;

import java.util.List;
import java.util.Scanner;

public class BtreeNode {

    public class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }

    public Node root;

    public void addData(Scanner scanner){
        System.out.println("enter value for root node:");
        int value=scanner.nextInt();
        root=new Node(value);
        addMoreData(scanner, root);
    }
    private void addMoreData(Scanner scanner, Node node){
        System.out.println("want data in left of ? "+node.data+" (true/false)");
        boolean left=scanner.nextBoolean();
        if(left){
            System.out.println("enter data:");
            int num=scanner.nextInt();
            node.left=new Node(num);
            addMoreData(scanner,node.left);
        }

        System.out.println("want data in right of ? "+node.data+" (true/false)");
        boolean right=scanner.nextBoolean();
        if(right){
            System.out.println("enter data:");
            int num=scanner.nextInt();
            node.right=new Node(num);
            addMoreData(scanner, node.right);
        }
    }

    public void display(){
        displayHelp(root,0);
    }
    private void displayHelp(Node node, int level){
        if(node==null)
            return;

        displayHelp(node.right,level+1);

        if(level!=0){
            for (int i=0;i<level-1;i++)
                System.out.print("\t\t");
            System.out.println("|------>"+node.data);
        } else {
            System.out.println(node.data);
        }

        displayHelp(node.left,level+1);
    }



    public void levelOrderTraversal(){

        int height=heightOfTree(root);
        for(int i=1;i<=height;i++){
            levelOrderTraversalHelp(root,i);
            System.out.println();
        }

    }
    private void levelOrderTraversalHelp(Node node, int level){
        if(node==null)
            return;

        if(level==1){
            System.out.print(node.data+" ");
            return;
        }

        levelOrderTraversalHelp(node.left,level-1);
        levelOrderTraversalHelp(node.right,level-1);

    }

    public int heightOfTree(Node node){
        if(node==null)
            return 0;
        return 1+Math.max( heightOfTree(node.left), heightOfTree(node.right) );
    }

    public void preorder(List<Integer> lst){
        preorderHelp(root,lst);
    }
    private void preorderHelp(Node node, List<Integer> lst){
        if(node==null)
            return;

        lst.add(node.data);// System.out.println(node.data);
        preorderHelp(node.left,lst);
        preorderHelp(node.right,lst);
    }

    public void invertedPreorder(List<Integer> lst){
        invertedPreorderHelp(root,lst);
    }
    private void  invertedPreorderHelp(Node node,List<Integer> lst){
        if(node==null)
            return;
        lst.add(node.data);// System.out.println(node.data);
        invertedPreorderHelp(node.right,lst);
        invertedPreorderHelp(node.left,lst);
    }



}
