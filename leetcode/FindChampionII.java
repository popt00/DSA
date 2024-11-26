//https://leetcode.com/problems/find-champion-ii/description/
class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] in = new int[n];
        for(int[] ar:edges){
            in[ar[1]]++;
        }
        int countIn=0, index=-1;
        for(int i=0;i<n;i++){
            if(in[i]==0){
                countIn++; index=i;
            }
        }
        return countIn==1? index:-1;
    }
}
