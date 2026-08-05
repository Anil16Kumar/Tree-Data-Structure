package problem.BInary_Search_Tree;

import java.util.Scanner;

public class MainActivity {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        BtreeNode btreeNode=new BtreeNode();
        btreeNode.addData(50);
        btreeNode.addData(30);
        btreeNode.addData(70);
        btreeNode.addData(20);
        btreeNode.addData(40);
        btreeNode.addData(60);
        btreeNode.addData(80);

        btreeNode.display();
        System.out.println("--------------------------");
        btreeNode.root=changeKey(btreeNode, 40,10);
        btreeNode.display();


    }

    public static BtreeNode.Node changeKey(BtreeNode node, int oldVal, int newVal){
        node.deleteData(oldVal);
        node.addData(newVal);
        return node.root;
    }

}
