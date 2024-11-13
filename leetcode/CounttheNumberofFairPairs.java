//https://leetcode.com/problems/count-the-number-of-fair-pairs
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans=0;
        for(int i=0;i<nums.length;i++){
            int st = getBinaryLower(nums,lower-nums[i]);
            int ed = getBinaryHigher(nums,upper-nums[i]);
            //System.out.println(nums[i]+"{"+st+","+ed+"}");
            ans = ans+ ed-st+1;
            if(st<=i && i<=ed)ans--;
        }
        return ans/2;
    }
    public int getBinaryLower(int[] nums,int val){
        int i=0,j=nums.length-1;
        if(nums[j]<val)return nums.length;
        while(i+1<j){
            int m = (i+j)/2;
            if(nums[m]<val)i=m;
            else j=m;
        }
        if(nums[i]>=val)return i;
        return j;
    }
    public int getBinaryHigher(int[] nums,int val){
        int i=0,j=nums.length-1;
        if(val<nums[0])return -1;
        while(i+1<j){
            int m = (i+j)/2;
            if(nums[m]<=val)i=m;
            else j=m;
        }
        if(nums[j]<=val)return j;
        return i;
    }
}
