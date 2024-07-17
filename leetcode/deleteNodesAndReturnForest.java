/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/description/
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set= new HashSet<>();
        for(int x:to_delete)set.add(x);

        List<TreeNode> ans = new ArrayList<>();
        List<TreeNode> que = new LinkedList<>();
        ans.add(root);
        que.add(root);
        while(!que.isEmpty()){
            TreeNode temp= que.removeFirst();
            TreeNode right= temp.right;TreeNode left= temp.left;
            if(right!=null){
                if(set.contains(right.val)){
                    temp.right=null;
                }
                que.add(right);
            }
            if(left!=null){
                if(set.contains(left.val)){
                    temp.left=null;
                }
                que.add(left);
            }
            if(set.contains(temp.val)){
                temp=null;
                if(right!=null)ans.add(right);
                if(left!=null)ans.add(left);
            }
        }
        List<TreeNode> finalAns = new ArrayList<>();
        for(TreeNode temp: ans){
            if(!set.contains(temp.val))finalAns.add(temp);
        }
        return finalAns;
    }
}
