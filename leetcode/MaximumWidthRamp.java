//https://leetcode.com/problems/maximum-width-ramp/description/
class Solution {
    public int maxWidthRamp(int[] nums) {
        ArrayList<int[]> ar=new ArrayList<>();
        ar.add(new int[]{nums[0],0});
        int ramp=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<ar.get(ar.size()-1)[0]){
                // int []temp=new int[]{nums[i],i};
                ar.add(new int[]{nums[i],i});
            }
            else{
                ramp=Math.max(ramp,findRamp(ar,nums[i],i));
            }
        }
        return ramp;
    }
    public int findRamp(ArrayList<int[]> ar, int val, int curr){
        int i=0,j=ar.size()-1;
        if(val>=ar.get(i)[0])return curr;
        if(val<ar.get(j)[0])return 0;
        while(i+1<j){
            int mid=(i+j)/2;
            if(ar.get(mid)[0]>val)i=mid;
            else j=mid;
        }
        if(ar.get(i)[0]<=val)return curr-ar.get(i)[1];
        if(ar.get(j)[0]<=val)return curr-ar.get(j)[1];
        return 0;
    }
}
