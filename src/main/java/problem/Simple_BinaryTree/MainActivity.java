package problem.Simple_BinaryTree;

import java.util.Scanner;

public class MainActivity {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.addData(new Scanner(System.in));

        binaryTree.display();

        binaryTree.prettyDisplay();
    }
}
