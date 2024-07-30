/*
* https://leetcode.com/problems/minimum-deletions-to-make-string-balanced
*/
class Solution {
    public int minimumDeletions(String s) {
        int totalA=0,n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a')totalA++;
        }
        int currB=0,currA=0,ans=totalA;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a')totalA--;
            else currB++;
            ans=Math.min(ans, currB + totalA);
        }
        return ans;
    }
}
