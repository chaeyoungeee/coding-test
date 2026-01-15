import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j != 9) {
                    dp[i + 1][j + 1] =
                        (dp[i + 1][j + 1] + dp[i][j]) % MOD;
                }
                if (j != 0) {
                    dp[i + 1][j - 1] =
                        (dp[i + 1][j - 1] + dp[i][j]) % MOD;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[n][i]) % MOD;
        }

        System.out.println(result);
    }
}