//https://leetcode.com/problems/most-beautiful-item-for-each-query/description/
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n=items.length,m=queries.length;
        int[][] ar=new int[n][2];
        for(int i=0;i<n;i++){ar[i][0]=items[i][0];ar[i][1]=items[i][1];}
        Arrays.sort(ar, new Comparator<>(){
            public int compare(int[] a, int [] b){
                if(a[0]==b[0]){
                    return Integer.compare(b[1],a[1]);
                }
                else return Integer.compare(a[0],b[0]);
            }
        });
        for(int i=1;i<n;i++){
            ar[i][1]=Math.max(ar[i][1],ar[i-1][1]);
        }
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            ans[i]=binarySearch(ar,queries[i]);
        }
        return ans;
    }
    public int binarySearch(int[][] ar, int val){
        int i=0,j=ar.length-1;
        if(val<ar[i][0])return 0;
        while(i+1<j){
            int m = (i+j)/2;
            if(ar[m][0]<=val)i=m;
            else j=m;
        }
        if(ar[j][0]<=val)return ar[j][1];
        return ar[i][1];
    }
}
