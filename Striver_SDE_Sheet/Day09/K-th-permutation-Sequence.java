class Solution {
    public String getPermutation(int n, int k) {
        // n (n-1) (n-2)....1
        // k = k-1 so first is 0 then 1.... n!-1
        // m=((n-1)(n-2)....)  k/m is the value:  and then we repeat
        int max= getFactorial(n);
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<n;i++)list.add(String.valueOf(i+1));
        String ans="";
        k--;
        while(n>0){
            max=max/n;
            ans+=list.remove((k/max));
            k=k%max;
            n--;
        }
        return ans;
    }
    public int getFactorial(int n){
        int i=1;
        while(n>1){
            i=i*n;
            n--;
        }
        return i;
    }
}
