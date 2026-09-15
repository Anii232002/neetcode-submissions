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
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> rightView = new ArrayList<>();
        dfs(root,map,0,rightView);
        return rightView;
    }

    public void dfs(TreeNode root,HashMap<Integer,Integer> map,int level,List<Integer> rightView ){

        if(root == null)return;
        if(!map.containsKey(level)){
            rightView.add(root.val);
            map.put(level,1);
        }
        dfs(root.right,map,level+1,rightView);
        dfs(root.left,map,level+1,rightView);
    }
}
