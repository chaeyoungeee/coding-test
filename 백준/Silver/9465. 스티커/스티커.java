import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();

            int[][] s = new int[2][n];

            for (int i = 0; i < n; i++)
                s[0][i] = sc.nextInt();

            for (int i = 0; i < n; i++)
                s[1][i] = sc.nextInt();


            int[][] dp = new int[2][n];
            dp[0][0] = s[0][0];
            dp[1][0] = s[1][0];

            if (n == 1) {
                System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
                continue;
            }

            dp[0][1] = dp[1][0] + s[0][1];
            dp[1][1] = dp[0][0] + s[1][1];

            if (n == 2) {
                System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
                continue;
            }

            for (int i = 2; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    dp[j][i] = Math.max(dp[1-j][i-1], 
                        Math.max(dp[0][i-2], dp[1][i-2])) + s[j][i];
                }
            }

            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
            
            // for (int[] d : dp) {
            //     System.out.println(Arrays.toString(d));
            // }
        }
    }
}