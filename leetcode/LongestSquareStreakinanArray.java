//https://leetcode.com/problems/longest-square-streak-in-an-array
class Solution {
    public int longestSquareStreak(int[] nums) {
        boolean isExist[] = new boolean[100000+1];
        for(int x:nums)isExist[x]=true;
        int ans=-1;
        for(int x:nums){
            int i=0;
            while(x<1000 && isExist[x]){
                i++;
                x=x*x;
            }
            if(x>=1000 && x<=100000 && isExist[x])i++;
            if(i>1)ans=Math.max(ans,i);
        }
        return ans;
    }
}
