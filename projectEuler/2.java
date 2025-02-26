public class Main {
    public static void main(String[] args) {
        long ans=0;
        int a=1,b=2,c=1;
        while(b<4000000){
            if((b&1)==0)ans+=b;
            //System.out.println(b);
            c=a+b;
            a=b;
            b=c;
        }
        System.out.println(ans);
    }
}

