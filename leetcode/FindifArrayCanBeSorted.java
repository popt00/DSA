//https://leetcode.com/problems/find-if-array-can-be-sorted/
class Solution {
    public boolean canSortArray(int[] nums) {
        int n= nums.length;
        // int[] ar=new int[n];
        // for(int i=0;i<n;i++)ar[i]=nums[i];
        // Arrays.sort(ar);
        int i=0;
        int pre=0;
        while(i<n){
            int bits=getBits(nums[i]);
            int currMax=nums[i];
            while(i<n && getBits(nums[i])==bits){
                if(pre>nums[i])return false;
                currMax=Math.max(nums[i],currMax);
                i++;
            }
            pre=currMax;
        }
        return true;
    }
    public int getBits(int x){
        int noOfBits=0;
        while(x!=0){
            noOfBits+= (x&1);
            x=(x>>1);
        }
        return noOfBits;
    }
}
