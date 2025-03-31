class Solution {
    public int majorityElement(int[] nums) {
        int majority=0,ans=0;
        for(int x:nums){
            if(majority==0)ans=x;
            if(ans==x)majority++;
            else majority--;
        }
        return ans;
    }
}
