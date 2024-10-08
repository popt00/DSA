//https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
class Solution {
    public int minSwaps(String s) {
        int i=0,j=s.length()-1;
        int pre=0,post=0;
        int swap=0;
        while(i<j){
            while(i<j && pre>=0){
                if(s.charAt(i++)=='[')pre++;
                else pre--;
            }
            while(i<j && post>=0){
                if(s.charAt(j--)==']')post++;
                else post--;
            }
            if(pre<0 || post<0){swap++;pre+=2;post+=2;}
        }
        return swap;
    }
}
