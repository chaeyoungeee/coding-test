import java.io.*;
import java.util.*;
class Main {
	static int[][] maps;
	static boolean[][] visited;
	static int N;
	static int MAX = 1;
	static int MIN = 100;
	static int cnt = 0;
	static int result = 0;
	static int[][] dir = {
		{1, -1, 0, 0},
		{0, 0, 1, -1}
	};
	
	static class Pos {
		int x, y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(int x, int y, int k) {
		Queue<Pos> que = new LinkedList<>();
		que.add(new Pos(x, y));
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			Pos p = que.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dir[0][i];
				int ny = p.y + dir[1][i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (visited[nx][ny]) continue;
				if (maps[nx][ny] <= k) continue;
				
				que.add(new Pos(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		maps = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				MAX = Math.max(MAX, maps[i][j]);
				MIN = Math.min(MIN, maps[i][j]);
			}
		}

		for (int k = 0; k < MAX + 1; k++) {
			visited = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && maps[i][j] > k) {
						bfs(i, j, k);
						cnt += 1;
					}
				}
			}
			result = Math.max(result, cnt);
		}

		System.out.println(result);
	}
}