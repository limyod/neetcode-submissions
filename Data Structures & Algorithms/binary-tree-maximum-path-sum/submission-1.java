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
    public int maxPathSum(TreeNode root) {
        return helper(root)[0];
    }

    public int[] helper(TreeNode root){
        //base case if node is null.
        if(root == null) return new int[]{Integer.MIN_VALUE,0};
        int[] leftRes = helper(root.left);
        int[] rightRes = helper(root.right);
        int overallMax = Math.max(leftRes[0], rightRes[0]);
        int leftNoFork = leftRes[1];
        int rightNoFork = rightRes[1];
        leftNoFork = Math.max(0, leftNoFork);
        rightNoFork = Math.max(0, rightNoFork);
        int nodeForkMax = root.val + leftNoFork + rightNoFork;
        overallMax = Math.max(overallMax, nodeForkMax);
        int noForkMax = root.val + Math.max(leftNoFork, rightNoFork);
        return new int[]{overallMax, noForkMax};
    }
}
