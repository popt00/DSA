//https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/
class Solution {
    long[] sum;
    public long kthLargestLevelSum(TreeNode root, int k) {
        sum=new long[100002];
        Arrays.fill(sum,-1);
        dfs(root,0);
        Arrays.sort(sum);
        return sum[sum.length-k];
    }
    public void dfs(TreeNode root, int height){
        if(root==null)return;
        if(sum[height]==-1)sum[height]=0;
        sum[height]+= root.val;
        dfs(root.left,height+1);
        dfs(root.right,height+1);
    }
}
