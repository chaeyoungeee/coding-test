import java.io.*;
import java.util.*;

public class Main {
    static int[] coin;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < n; i++) {
            s.add(Integer.parseInt(br.readLine()));
        }

        coin = s.stream()
            .sorted((a, b) -> Integer.compare(a, b))
            .mapToInt(x->x)
            .toArray();

        int[] dp = new int[k+1];
        Arrays.fill(dp, 10001);

        dp[0] = 0;
        
        for (int c : coin) {
            for (int i = c; i < k+1; i ++) {
                dp[i] = Math.min(dp[i-c]+1, dp[i]);
            }
        }
        
        System.out.println(dp[k] == 10001 ? -1 : dp[k]);
    }
}