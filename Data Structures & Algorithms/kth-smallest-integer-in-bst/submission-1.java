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
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[2];
        ans[1] = -1;
        findKthSmallest(root,k,ans);
        return ans[1];
    }
    private void findKthSmallest(TreeNode root,int k,int[] ans){

        if(root==null)return ;

        findKthSmallest(root.left,k,ans);
        if(ans[0]==k-1){
            ans[1] = root.val;
        }
        ans[0]++;
        findKthSmallest(root.right,k,ans);

        return ;
    }
}
