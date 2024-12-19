//https://leetcode.com/problems/max-chunks-to-make-sorted/
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxBefore=0,ans=0;
        for(int i=0;i<arr.length;i++){
            if(maxBefore<arr[i])maxBefore=arr[i];
            if(maxBefore<=i)ans++;
        }
        return ans;
    }
}
