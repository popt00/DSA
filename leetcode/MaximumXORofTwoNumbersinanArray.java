//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
class Solution {
    class TreeNode{
        TreeNode zero;
        TreeNode one;
        boolean end;
        void add(int x){
            TreeNode cur=this;
            for(int i=31;i>=0;i--){
                if(((1<<i)&x)!=0){
                    if(cur.one==null)cur.one=new TreeNode();
                    cur=cur.one;
                }
                else{
                    if(cur.zero==null)cur.zero=new TreeNode();
                    cur=cur.zero;
                }
            }
            cur.end=true;
        }
    }
    public int findMaximumXOR(int[] nums) {
        TreeNode root=new TreeNode();
        for(int x:nums)root.add(x);
        return helper(root,31);
    }
    public int helper(TreeNode root, int exp){
        if(exp==0){
            if(root.one!=null&&root.zero!=null)return 1;
            return 0;
        }
        if(root.one!=null && root.zero!=null){
            return helper(root.zero,root.one,exp-1)+ (1<<exp);
        }
        if(root.one!=null)return helper(root.one,exp-1);
        if(root.zero!=null)return helper(root.zero,exp-1);
        return 0;
    }
    public int helper(TreeNode root, TreeNode root2, int exp){
        if(root==null || root2==null){
            return -1;
        }
        if(exp==0){
            if(root.one!=null&&root2.zero!=null)return 1;
            if(root.zero!=null&&root2.one!=null)return 1;
            if(root.one!=null&&root2.one!=null)return 0;
            if(root.zero!=null&&root2.zero!=null)return 0;
            return -1;
        }
        int val= Math.max(
            helper(root.one,root2.zero,exp-1),helper(root.zero,root2.one,exp-1)
            );
        if(val!=-1)return val + (1<<exp);
        val= Math.max(
            helper(root.one,root2.one,exp-1),helper(root.zero,root2.zero,exp-1)
            );
        if(val!=-1)return val;
        return -1;
    }
}
