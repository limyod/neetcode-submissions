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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if root is p or q, this is the lowest common ancestor.
        if(p == root || q == root) return root;
        //if the value of p and q are less than the root, lets go left.
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q); 
        //if the value of p and q are greater than root, lets go right.
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q); 
        //if p and q are on opposite sides, this is the lowest common ancesotr
        return root;
    }
}
