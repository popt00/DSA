class Solution {
    public int findDuplicate(int[] nums) {
        //nums.length = 10000000;
        // boolean[] vis= new boolean[nums.length];
        int slow=nums[nums[0]],fast=nums[nums[nums[0]]];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
