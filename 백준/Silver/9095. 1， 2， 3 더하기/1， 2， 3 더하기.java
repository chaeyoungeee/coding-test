import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] input = new int[t];
        int max = 0;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            input[i] = n;
            max = Math.max(max, n);
        }

        int[] dp = new int[max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < max+1; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for (int i : input) {
            System.out.println(dp[i]);
        }
    }
}