import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N]; 
		int[] m = new int[N];
		int[] dp = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			d[i] = Integer.parseInt(st.nextToken());
			m[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			if (i != 0) dp[i] = Math.max(dp[i-1], dp[i]);
			int j = i + d[i];
			if (j > N) continue;
			dp[j] = Math.max(dp[j], dp[i] + m[i]);
		}
		
		int result = Arrays.stream(dp).max().getAsInt();
		System.out.println(result);
	}
}