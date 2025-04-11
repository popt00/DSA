class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)return nums[0];
        int st=0,ed=nums.length-1;
        while(st+1<ed){
            int mid=(st+ed)/2;
            // int mid2= mid + (mid%2==0 ?1:-1);
            if(mid%2==0){
                //(mid,mid+1)
                // if(mid+1>=nums.length)
                if(nums[mid]==nums[mid+1])st=mid+2;
                else ed=mid+1;
            }
            else{
                //(mid-1,mid)
                if(nums[mid-1]==nums[mid])st=mid+1;
                else ed=mid;
            }
        }
        boolean isSt=false,isEd=false;
        if(st>0 && nums[st]!=nums[st-1])return nums[st];
        if(nums[st]!=nums[st+1])return nums[st];
        return nums[ed];
    }
}
