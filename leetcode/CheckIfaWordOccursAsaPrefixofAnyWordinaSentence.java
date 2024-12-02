//https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/description/
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int i=0,count=1;
        while(i<sentence.length()){
            if(checkSameWord(sentence,i,searchWord))return count;
            i= nextIndex(sentence,i);
            count++;
            i++;
        }
        return -1;
    }
    public boolean checkSameWord(String sent, int index, String valStr){
        int i=0;
        while(i<valStr.length() && index+i<sent.length()){
            if(sent.charAt(index+i)==valStr.charAt(i))i++;
            else return false;
        }
        return i==valStr.length();
    }
    public int nextIndex(String str, int i){
        while(i<str.length() && str.charAt(i)!=' '){
            i++;
        }
        return i;
    }
}
