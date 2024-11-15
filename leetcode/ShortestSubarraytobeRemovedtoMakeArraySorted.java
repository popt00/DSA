//https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/description/
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length;
        int st=0,ed=n-1;
        while(st<n-1 && arr[st]<=arr[st+1])st++;
        while(ed>0 && arr[ed-1]<=arr[ed])ed--;
        if(st>=ed)return 0;
        int ans = Math.min(ed,n-st-1);
        int i=0,j=ed;
        while(i<=st && j<n){
            if(arr[i]<=arr[j]){
                ans=Math.min(j-i-1,ans);
                i++;
            }
            else{
                j++;
            }
        }
        return ans;
    }
}
