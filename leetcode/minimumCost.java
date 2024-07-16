/*
* https://leetcode.com/problems/minimum-cost-for-cutting-cake-ii/
*/
class Solution {
    public long minimumCost(int m, int n, int[] hori, int[] vert) {
        Arrays.sort(hori);Arrays.sort(vert);
        reverseArray(hori);reverseArray(vert);
        long sumh=0;
        for(int i=0;i+1<m;i++){sumh+=hori[i];}

        long sumv=0;
        for(int i=0;i+1<n;i++){sumv+=vert[i];}

        int i=0,j=0;
        long ans=0;
        while(i+1<m && j+1<n){
            if(hori[i]<vert[j]){
                ans= ans + vert[j] + sumh;
                sumv-=vert[j++];
            }
            else{
                ans = ans + hori[i] + sumv;
                sumh-=hori[i++];
            }
        }
        return ans+sumv+sumh;
    }
    private static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // Swap elements at left and right indices
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            // Move indices towards the center
            left++;
            right--;
        }
    }
}
