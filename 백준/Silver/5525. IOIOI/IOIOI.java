import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] dp = new int[m];
        int answer = 0;

        for (int i = 2; i < m; i++) {
            if (s.charAt(i) == 'I' && s.charAt(i-2) == 'I' && s.charAt(i-1) == 'O') {
                dp[i] = dp[i-2] + 1;
                if (dp[i] == n) {
                    dp[i] -= 1;
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}