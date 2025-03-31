class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=0,n=nums.length;
        while(j<n){
            nums[i]=nums[j];
            while(j<n && nums[j]==nums[i])j++;
            i++;
        }
        return i;
    }
}
