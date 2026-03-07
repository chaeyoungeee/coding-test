import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < n; i++) {
            s.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[k+1];
        Arrays.fill(dp, k+1);
        dp[0] = 0;
        int[] value = s.stream()
            .sorted((a, b) -> Integer.compare(a, b))
            .mapToInt(x->x)
            .toArray();

        for (int v : value) {
            for (int i = v; i <= k; i++) {
                dp[i] = Math.min(dp[i-v]+1, dp[i]);
            }
        }

        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[k] == k+1 ? -1 : dp[k]);
    }
}