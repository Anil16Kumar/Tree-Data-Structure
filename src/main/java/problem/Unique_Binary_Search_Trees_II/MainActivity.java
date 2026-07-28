package problem.Unique_Binary_Search_Trees_II;

import java.util.ArrayList;
import java.util.List;

/*
    LeetCode 95. Unique Binary Search Trees II

    Given an integer n, return all structurally unique BST's (Binary Search Trees),
    which have exactly n nodes of unique values from 1 to n.

    Return the answer in any order.

    Example:

    Input:
        n = 3

    Output:
        [
            [1,null,2,null,3],
            [1,null,3,2],
            [2,1,3],
            [3,1,null,null,2],
            [3,2,null,1]
        ]

    ----------------------------------------------------------

    Idea:

    For every number from start to end:
        1. Choose it as the root.
        2. Recursively generate all possible left subtrees.
        3. Recursively generate all possible right subtrees.
        4. Combine every left subtree with every right subtree.

    This generates all unique BSTs.
*/


/*
                    Example (n = 3)

                    Numbers:
                    1   2   3


                Choose 2 as Root

                        2
                      /   \
                     ?     ?

            Left Range : [1]
            Right Range: [3]

            Only one possibility:

                        2
                      /   \
                     1     3


----------------------------------------------------------------


                Choose 1 as Root

                        1
                         \
                          ?

            Left Range : []
            Right Range: [2,3]

            Right subtree can be:

                    2               3
                     \             /
                      3           2

            Therefore two BSTs:

                    1               1
                     \               \
                      2               3
                       \             /
                        3           2


----------------------------------------------------------------


                Choose 3 as Root

                        3
                       /
                      ?

            Left Range : [1,2]
            Right Range: []

            Left subtree can be:

                    1               2
                     \             /
                      2           1

            Therefore two BSTs:

                      3               3
                     /               /
                    1               2
                     \             /
                      2           1


----------------------------------------------------------------

Total Unique BSTs = 5
*/


/*
                Cartesian Product Concept

        Left Subtrees              Right Subtrees

            L1                         R1
            L2                         R2
                                       R3


        Every Left combines with Every Right

            L1 + R1
            L1 + R2
            L1 + R3

            L2 + R1
            L2 + R2
            L2 + R3


        Code:

        for(TreeNode left : leftTrees){
            for(TreeNode right : rightTrees){

                TreeNode root = new TreeNode(i);
                root.left = left;
                root.right = right;

                answer.add(root);
            }
        }

        This is the heart of the solution.
*/

public class MainActivity {
    public static void main(String[] args) {
        System.out.println(genrateTree(3));
    }
    public static List<TreeNode> genrateTree(int n){
        
        if(n==0)
            return new ArrayList<>();
        return genrate(1,n);
    }
    public static List<TreeNode> genrate(int start,int end){
        List<TreeNode> answer=new ArrayList<>();
        if(start>end){
            answer.add(null);
            return answer;
        }

        for(int i=start;i<=end;i++){
            List<TreeNode> lst=genrate(start,i-1);
            List<TreeNode> rst=genrate(i+1,end);
            for(TreeNode lval:lst){
                for(TreeNode rval: rst){
                    TreeNode node=new TreeNode(i);
                    node.left=lval;
                    node.right=rval;
                    answer.add(node);
                }
            }
        }
        return answer;
    }
}

