//https://leetcode.com/problems/maximum-swap/
class Solution {
    public int maximumSwap(int num) {
        char[] chs= String.valueOf(num).toCharArray();
        
        for(int i=0;i<chs.length;i++){
            int maxIndex=i;
            for(int j=i+1;j<chs.length;j++){
                if(chs[maxIndex]<=chs[j]){
                    maxIndex=j;
                }
            }
            if(chs[i]!=chs[maxIndex]){
                char temp=chs[i];chs[i]=chs[maxIndex];chs[maxIndex]=temp;
                return Integer.parseInt(new String(chs));
            }
        }
        return num;
    }
}
