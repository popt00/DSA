//https://leetcode.com/problems/maximum-xor-for-each-query/description/
class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n=nums.length,xorTillNow=0,andValue= (1<<maximumBit)-1;
        int [] ans=new int[n];
        for(int i=0;i<n;i++){
            xorTillNow=xorTillNow^nums[i];
            ans[n-i-1]= ((~xorTillNow)&andValue);
        }
        return ans;
    }
}
