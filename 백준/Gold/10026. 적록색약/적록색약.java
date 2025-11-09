import java.io.*;
import java.util.*;
class Main {
	static char[][] maps;
	static char[][] colorBlindMaps;
	static boolean[][] visited;
	static int N;
	static int[] result = {0, 0};
	static int[][] dir = {
		{1, -1, 0, 0},
		{0, 0, 1, -1}
	};
	
	static void dfs(int x, int y, char[][] maps) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[0][i];
			int ny = y + dir[1][i];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (visited[nx][ny]) continue;
			if (maps[x][y] != maps[nx][ny]) continue;	
			
			dfs(nx, ny, maps);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		maps = new char[N][N];
		colorBlindMaps = new char[N][N];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < N; j++)  {
				maps[i][j] = input[j].charAt(0);
				if (input[j].charAt(0) == ('G')) {
					colorBlindMaps[i][j] = 'R';
				} else {
					colorBlindMaps[i][j] = input[j].charAt(0);
				}
			}
		}

		for (int k = 0; k < 2; k++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)  {
					if (!visited[i][j]) {
						if (k == 0) {
							dfs(i, j,maps);
						} else {
							dfs(i, j, colorBlindMaps);
						}
						cnt += 1;
					}
				}
			}
			result[k] = cnt;
		}

		System.out.printf("%d %d", result[0], result[1]);
	}
}