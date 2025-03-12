public class Solution {
  public static void main(String[] args) {
        long n=600851475143L;
        System.out.println(solve(n));
    }
  
  public static long solve(long n){
        int i=2;
        long maxN= (long)(Math.sqrt(n));
        while(i<=maxN){
            if(n%i==0){
                n=n/i;
                maxN= (long)(Math.sqrt(n));
                i=2;
            }
            else i++;
        }
        return n;
    }
}
