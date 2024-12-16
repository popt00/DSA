//https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k-->0){
            doThing(nums,multiplier);
        }
        return nums;
    }
    public void doThing(int[] nums, int mul){
        int minIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[minIndex])minIndex=i;
        }
        nums[minIndex]=nums[minIndex]*mul;
    }
}
