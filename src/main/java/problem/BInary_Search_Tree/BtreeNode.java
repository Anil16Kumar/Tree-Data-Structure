package problem.BInary_Search_Tree;

public class BtreeNode {

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
        root=addDataHelper(root, data);
    }
    private Node addDataHelper(Node node, int data){
        if(node==null)
            return new Node(data);
        if(node.data>data)
            node.left=addDataHelper(node.left, data);
        else if(node.data<data)
            node.right=addDataHelper(node.right,data);
        return node;
    }

    public void deleteData(int val){
        root=deleteDataHelp(root, val);
    }
    private Node deleteDataHelp(Node node, int val){
        if(node==null){
            System.out.println("value not found");
            return node;
        }
        if(node.data>val){
            node.left=deleteDataHelp(node.left, val);
        } else if(node.data<val){
            node.right=deleteDataHelp(node.right,val);
        } else {
            if(node.left==null && node.right==null)
                return null;
            if(node.right==null )
                return node.left;
            if(node.left==null)
                return node.right;

            Node successer=findMin(node.right);

            node.data=successer.data;

            node.right=deleteDataHelp(node.right, successer.data);
        }
        return node;
    }
    private Node findMin(Node node){
        while(node.left!=null)
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
        }else{
            System.out.println(node.data);
        }

        displayHelper(node.left, level+1);
    }

}
