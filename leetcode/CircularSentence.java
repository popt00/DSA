//https://leetcode.com/problems/circular-sentence/
class Solution {
    public boolean isCircularSentence(String sentence) {
        int i=0,n= sentence.length();
        if(sentence.charAt(0)!=sentence.charAt(n-1))return false;
        while(i<n){
            if(sentence.charAt(i)==' ' && sentence.charAt(i-1)!=sentence.charAt(i+1))
                return false;
            i++;
        }
        return true;
    }
    
}
