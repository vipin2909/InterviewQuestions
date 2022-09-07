import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// template file for competitive programming -> for fast inputs
public class Main {

    BufferedReader br;
    StringTokenizer tok;
    PrintWriter out;
    int testCases;

    /*
     *@return string input
     * @throws IOException
     */
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
            Main main = new Main();
            main.br = new BufferedReader(new InputStreamReader(System.in));
            main.out = new PrintWriter(System.out);
            main.solve();
            main.br.close();
            main.out.close();
        }
        catch(Throwable e) {
            e.printStackTrace();
        }
    }
}
