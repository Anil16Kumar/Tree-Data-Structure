package problem.Maximum_In_Every_Level;

import java.util.*;

public class LevelTreeNode {

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

    public void addData(Scanner scanner){
        System.out.println("enter data for root:");
        int data=scanner.nextInt();
        root=new Node(data);

        addMoreData(scanner, root);
    }
    private void addMoreData(Scanner scanner, Node node){
        System.out.println("want data in left of "+node.data+" ? true/false");
        boolean left=scanner.nextBoolean();
        if(left){
            System.out.println("enter data:");
            int data=scanner.nextInt();
            node.left=new Node(data);
            addMoreData(scanner, node.left);
        }

        System.out.println("want data in right of "+node.data+" ? true/false");
        boolean right=scanner.nextBoolean();
        if(right){
            System.out.println("enter data:");
            int data=scanner.nextInt();
            node.right=new Node(data);
            addMoreData(scanner, node.right);
        }
    }

    public void diplay(){
        diplayHelp(root,0);
    }
    private void diplayHelp(Node node, int level){
        if(node==null)
            return;

        diplayHelp(node.right, level+1);

        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("\t\t");
            System.out.println("|----->"+node.data);
        } else {
            System.out.println(node.data);
        }

        diplayHelp(node.left, level+1);
    }

    public void allPathFromRootToLeaf(){
        allPathFromRootToLeafHelp(root, new ArrayList<Integer>());
    }
    private void allPathFromRootToLeafHelp(Node node, List<Integer> lst){
        if(node==null)
            return;

        lst.add(node.data);
        if(node.right==null && node.left==null){
            System.out.println(lst);
        } else {
            allPathFromRootToLeafHelp(node.left, lst);
            allPathFromRootToLeafHelp(node.right, lst);
        }

        lst.removeLast();
    }

    public void levelOrder(){
        levelOrderHelp(root);
    }
    private void levelOrderHelp(Node node){
        if(node==null)
            return;

        Queue<Node> que=new LinkedList<>();
        que.add(node);
        while(!que.isEmpty()){

            int size=que.size();

            for(int i=0;i<size;i++) {
                Node temp = que.poll();

                System.out.print(temp.data+" ");
                if (temp.left != null) que.add(temp.left);
                if (temp.right != null) que.add(temp.right);
            }
            System.out.println();
        }
    }

}
