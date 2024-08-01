/*
* https://leetcode.com/problems/filling-bookcase-shelves
*/
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n=books.length;
        int []dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
            dp[i+1]=dp[i]+books[i][1];
            int partWidth=books[i][0], partMaxHeight=books[i][1];
            // we are already including last book in last_shelf
            //now adding another if we can in first iteration
            for(int j=i-1;j>=0;j--){
                partWidth+=books[j][0];
                if(partWidth>shelfWidth) break; //we check if we can place that book in last_shelf
                partMaxHeight=Math.max(partMaxHeight,books[j][1]);
                dp[i+1]=Math.min(dp[i+1], dp[j]+partMaxHeight);// we merge till that book
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
