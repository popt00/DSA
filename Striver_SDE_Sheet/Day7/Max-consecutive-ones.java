class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0,n=nums.length,max=0;
        while(i<n){
            int ones=0;
            while(i<n && nums[i]==1){
                ones++;
                i++;
            }
            i++;
            max=Math.max(max,ones);
        }
        return max;
    }
}
