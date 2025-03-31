class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        int n=wt.size();
        double[][] dp=new double[n][2];
        for(int i=0;i<n;i++){
            dp[i][1]=wt.get(i); //weight
            dp[i][0]=val.get(i)/dp[i][1]; ///value/weight
        }
        Arrays.sort(dp, new Comparator<>(){
            public int compare(double[] a, double[] b){
                return Double.compare(b[0],a[0]);
            }   
        });
        double spaceRemaining=capacity, totalValue=0;
        int i=0;
        while(spaceRemaining>0 && i<n ){
            double maxCanFill =Math.min(spaceRemaining,dp[i][1]);
            spaceRemaining-=maxCanFill;
            totalValue+= dp[i][0] * maxCanFill;
            i++;
        }
        return totalValue;
    }
}
