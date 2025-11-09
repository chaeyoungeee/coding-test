import java.io.*;
import java.util.*;
class Main {
	static int[][] maps;
	static int N;
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

	static int dfs(int x, int y) {
		maps[x][y] = -1;
		int cnt = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[0][i];
			int ny = y + dir[1][i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (maps[nx][ny] == -1) continue;
			
			cnt += dfs(nx, ny);
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> result = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		maps = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < N; j++)  {
				int k = Integer.parseInt(input[j]);
				maps[i][j] = k == 1 ? k : -1;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)  {
				if (maps[i][j] == 1) {
					int cnt = dfs(i, j);
					result.add(cnt);
				}
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		
		for (int i = 0; i < result.size(); i++) {
					System.out.println(result.get(i));
		}
	}
}