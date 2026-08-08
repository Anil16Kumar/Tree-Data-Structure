package problem.VisitLeavesWithBudget;
/*
You have some money (budget).

Each leaf node has a cost = its level (depth) in the tree.

Your goal is to visit the maximum number of leaf nodes without spending more than your budget.

Example
        1  (Level 1)
       / \
      2   3  (Level 2)
     / \   \
    4   5   6  (Level 3)

Leaf nodes are:

4 → Cost = 3
5 → Cost = 3
6 → Cost = 3

Budget = 6

You can visit:

4 (cost 3) + 5 (cost 3) = 6 ✅

Visited leaves = 2

Another Example
        1
       /
      2
     /
    3
   /
  4

Leaf:

4 → Level = 4 → Cost = 4

Budget = 3

Cost = 4 > Budget = 3

Answer = 0
* */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode();
        treeNode.addData(10);
        treeNode.addData(8);
        treeNode.addData(2);
        treeNode.addData(3);
        treeNode.addData(13);
        treeNode.addData(6);
        treeNode.addData(4);

        treeNode.display();
        treeNode.rootToLeaf();

        System.out.println("->"+getCount_VisitLeavesWithBudget(treeNode.root, 8));
    }
    public static int getCount_VisitLeavesWithBudget(TreeNode.Node root, int k){

        List<Integer> answer=new ArrayList<>();
        rootToLeafPath(root, new ArrayList<>(), answer);
        Collections.sort(answer);
        int count = 0;

        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) > k)
                break;

            k -= answer.get(i);
            count++;
        }

        return count;
    }

    private static void rootToLeafPath(TreeNode.Node node, List<Integer> lst, List<Integer> answer){
        if(node==null)
            return;

        lst.add(node.data);

        if(node.right==null && node.left==null){
            answer.add(lst.size());
        }else{
            rootToLeafPath(node.left, lst, answer);
            rootToLeafPath(node.right, lst, answer);
        }

        lst.removeLast();
    }
}
