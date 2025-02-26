//https://codeforces.com/problemset/problem/489/C
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        private int n;
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n= in.nextInt();
            int sum=in.nextInt();
            if(n*9<sum || (n>1 && sum==0)){
                out.println("-1 -1");
                return;
            }
            int a=n,total=sum;
            String min="";
            while(a-->0){ // a=1 if a==2
                if(a==0)min= String.valueOf(total)+min;
                else{
                    if(total>9){
                        min= String.valueOf(9)+min;
                        total-=9;
                    }
                    else{
                        if(total==1){
                            min= String.valueOf(0)+min;
                        }
                        else{
                            min= String.valueOf(total-1)+min;
                            total=1;
                        }
                    }
                }
            }
            out.print(min+" ");
            total=sum;
            a=n;
            while(a-->0){
                if(total>9){
                    out.print(9);
                    total-=9;
                }
                else{
                    out.print(total);
                    total-=total;
                }
            }
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

