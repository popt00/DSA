//https://leetcode.com/problems/construct-k-palindrome-strings/description/
class Solution {
    public boolean canConstruct(String s, int k) {
        if(k>s.length())return false;
        int[] ar=new int[26];
        for(Character ch: s.toCharArray()){
            ar[(int)(ch-'a')]++;
        }
        int odd=0;
        for(int x:ar)if(x%2==1)odd++;
        if(odd<=k)return true;
        return false;
    }
}
