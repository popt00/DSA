//https://leetcode.com/problems/separate-black-and-white-balls/
class Solution {
    public long minimumSteps(String s) {
        int left=0,right=s.length()-1;
        long ans=0;
        while(left<right){
            if(s.charAt(left)=='0')left++;
            else if(s.charAt(right)=='1')right--;
            else {
                ans= ans+right-left;
                left++;
                right--;
            }
        }
        return ans;
    }
}
