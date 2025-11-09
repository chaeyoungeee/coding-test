import java.io.*;
import java.util.*;
class Main {
	static class Pos {
		int time;
		int x;
		Pos(int time, int x) {
			this.time = time;
			this.x = x;
		}
	}
	
	public static int bfs(int n, int k) {
		if (n == k) {
			return 0;
		}
		
		Queue<Pos> que = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		que.add(new Pos(0, n));
		
		while(!que.isEmpty()) {
			Pos p = que.poll();
			int nx;
			
			for (int dx : new int[]{2, 1, -1}) {
				nx = dx == 2 ? p.x * dx : p.x + dx;
				if (nx < 0 || nx > 100000 || visited.contains(nx)) continue;
				if (nx == k) return p.time+1;
				que.add(new Pos(p.time+1, nx));
				visited.add(nx);
			}		
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int result = bfs(n, k);
		System.out.println(result);
	}
}