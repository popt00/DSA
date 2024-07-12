/*
* https://codeforces.com/contest/1992/problem/A
* for 5 times just need to increment lowest number out of 3(check everytime)
* */
import java.util.Arrays;
import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        int t=0;
        Scanner s= new Scanner(System.in);
        t=s.nextInt();
        int [] arr=new int[3];
        while(t-->0){
            arr[0]=s.nextInt();
            arr[1]=s.nextInt();
            arr[2]=s.nextInt();
            for(int i=0;i<5;i++){
                Arrays.sort(arr);
                arr[0]++;
            }
            System.out.println(arr[0]*arr[1]*arr[2]);
        }
    }
}
