//https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
class Solution {
    public char findKthBit(int n, int k) {
        int section=(int)(1<<n);
        int assumed=1;
        while(section!=2){
            if(section/2==k)return (char)('0'+assumed);
            if(k>section/2){
                k= section - k;
                assumed=1-assumed;
            }
            section=section/2;
        }
        return (char)('0'+1-assumed);
    }
}
