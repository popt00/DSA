//https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
class Solution {
    int count,val;
    public int countMaxOrSubsets(int[] nums) {
        val=0;
        count=0;
        for(int x:nums)val=(val|x);
        backtrack(nums,0,0);
        return count;
    }
    public void backtrack(int[] nums, int i, int current){
        if(current==val){
            count++;
        }
        while(i<nums.length){
            backtrack(nums,i+1,current|nums[i]);
            i++;
        }
    }
}
