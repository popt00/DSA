//https://www.naukri.com/code360/problems/count-inversions_615?leftPanelTabValue=PROBLEM
import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        return sort(arr,0,n-1);
    }
    public static long sort(long[] arr, int st, int ed){
        if(st+1==ed){
            if(arr[st]>arr[ed]){
                swap(arr,st,ed);
                return 1;
            }
            return 0;
        }
        if(st==ed){
            return 0;
        }
        int mid= (st+ed)/2;
        long left = sort(arr,st,mid);
        long right = sort(arr,mid+1,ed);
        long mid_sum=  merge(arr,st,ed);
        // System.out.println(mid_sum + ","+left+","+right);
        // printt(arr,st,ed);
        return left+mid_sum+right;
    }
    public static void printt(long [] arr, int st, int ed){
        System.out.print("["+st+","+((st+ed)/2)+","+ed+"] : ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println("");
    }
    public static void swap(long[] arr,int i, int j){
        long temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static long merge(long[] arr, int st, int ed){
        // printt(arr,st,ed);
        int mid= (st+ed)/2;
        long[] newAr= new long[ed-st+1];
        int i_newAr=0,i_st=st,i_ed=mid+1;
        long adder=0;
        while(i_st <= mid && i_ed <= ed){
            if(arr[i_ed] < arr[i_st]){
                adder=adder+1l*(mid-i_st+1);
                newAr[i_newAr++]=arr[i_ed++];
            }
            else {
                newAr[i_newAr++]=arr[i_st++];
            }
        }
        while(i_st <= mid){
            // adder=adder+1l*(ed-mid);
            newAr[i_newAr++]=arr[i_st++];
        }
        while(i_ed <= ed){
            newAr[i_newAr++]=arr[i_ed++];
        }
        i_newAr=0;
        i_st=st;
        while(i_newAr<newAr.length){
            arr[i_st++]=newAr[i_newAr++];
        }
        return adder;

    }
}
