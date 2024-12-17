//https://leetcode.com/problems/construct-string-with-repeat-limit
class Solution {
    public String repeatLimitedString(String s, int limit) {
        int[] ar= new int[26];
        for(int i=0;i<s.length();i++)ar[(int)(s.charAt(i)-'a')]++;
        StringBuilder sb= new StringBuilder();
        int index[]=new int[2];
        index[0]=getNext(ar,25);
        index[1]=getNext(ar,index[0]-1);
        while(index[0]>=0){
            if(ar[index[0]]<=limit){
                sb.append(repeat(index[0],ar[index[0]]));
                index[0]=index[1];
                index[1]=getNext(ar,index[1]-1);
            }
            else{
                sb.append(repeat(index[0],limit));
                ar[index[0]]-=limit;
                if(index[1]<0)break;
                sb.append(repeat(index[1],1));
                ar[index[1]]--;
                if(ar[index[1]]==0)index[1]=getNext(ar,index[1]-1);
            }
        }
        return sb.toString();
    }
    public String repeat(int c, int n){
        String str= Character.toString((char)(c+'a'));
        return str.repeat(n);
    }
    public int getNext(int[] ar, int i){
        while(i>=0 && ar[i]==0)i--;
        return i;
    }
}
