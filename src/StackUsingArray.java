import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackUsingArray {

    BufferedReader br;
    StringTokenizer tok;
    PrintWriter out;
    int testCases;

    public String next() throws IOException {
        while(tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(br.readLine());
        }
        return tok.nextToken();
    }

    /*
     * @return integer input
     * @throws IOException
     */
    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    /*
    *@return long input
    * @throws IOException
     */
    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public void solve() throws IOException {
        testCases = nextInt();
        int[] arr = new int[testCases];
        for(int i = 0; i < testCases; i++) {
            arr[i] = nextInt();
        }
        for(int i = 0; i < testCases; i++) {
            out.print(arr[i] * 10 + "\t");
        }
    }

    public static void main(String[] args) {
        try {
            StackUsingArray stackUsingArray = new StackUsingArray();
            stackUsingArray.br = new BufferedReader(new InputStreamReader(System.in));
            stackUsingArray.out = new PrintWriter(System.out);
            stackUsingArray.solve();
            stackUsingArray.br.close();
            stackUsingArray.out.close();
        }
        catch(Throwable e) {
            e.printStackTrace();
        }
    }
}
