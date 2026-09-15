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
    public int goodNodes(TreeNode root) {
        return traverse(root,root.val);
    }

    public int traverse(TreeNode root, int maxTillNow){

        int leftGoodNodes = root.left!=null ? traverse(root.left,Math.max(maxTillNow,root.left.val)) : 0;
        int rightGoodNodes = root.right!=null ? traverse(root.right,Math.max(maxTillNow,root.right.val)):0;

        int isRootGood = root.val >= maxTillNow ? 1: 0;

        return leftGoodNodes + rightGoodNodes + isRootGood;
    }
}
