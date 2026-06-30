/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //at each node, check if its a subroot, check if their children are subRoots
        //first make sure they are both non-null
        //this is a valid subTree
        if(subRoot == null) return true;
        if(root == null) return false;
        if(root.val == subRoot.val){
            if(matchingTree(root, subRoot)) return true;
        }
        //check that the left and right might be a subTree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean matchingTree(TreeNode r1, TreeNode r2){
        if(r1 != null && r2 != null && r1.val == r2.val){
            return matchingTree(r1.left, r2.left) && matchingTree(r1.right, r2.right);
        }
        if(r1 == null && r2 == null) return true;
        return false;
    }

}
