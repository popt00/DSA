//https://leetcode.com/problems/cousins-in-binary-tree-ii/
class Solution {
    int[] sum;
    public TreeNode replaceValueInTree(TreeNode root) {
        sum= new int[100003];
        dfs(root,0);
        changedfs(root,0,root.val);
        return root;
    }
    public void dfs(TreeNode root, int height){
        if(root==null)return;
        sum[height]+=root.val;
        dfs(root.left,height+1);
        dfs(root.right,height+1);
    }
    public void changedfs(TreeNode root, int height, int siblingSum){
        root.val=sum[height]-siblingSum;
        int childSum = 0;
        if(root.left!=null)childSum+=root.left.val;
        if(root.right!=null)childSum+=root.right.val;
        if(root.left!=null)changedfs(root.left,height+1,childSum);
        if(root.right!=null)changedfs(root.right,height+1,childSum);
    }
}
