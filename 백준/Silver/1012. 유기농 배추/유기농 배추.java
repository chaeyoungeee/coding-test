import java.io.*;
import java.util.*;
class Main {
	static int[][] maps;
	static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int n;
	static int m;
	
	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(Pos pos) {
		Queue<Pos> que = new LinkedList<>();
		que.add(pos);
		maps[pos.x][pos.y] = 0;

		while (!que.isEmpty()) {
			Pos newPos = que.poll();
			for (int[] dir : dirs) {
				int nx = newPos.x + dir[0];
				int ny = newPos.y + dir[1];
			
				if (nx < 0 || nx >= n || ny < 0 || ny >=m) continue;
				if (maps[nx][ny] == 0) continue;
				que.add(new Pos(nx, ny));
				maps[nx][ny] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		//각 테스트 케이스
		for (int r = 0; r < T ; r++) {
			int count = 0;
			
			//입력
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			maps = new int[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				maps[x][y] = 1;
			}

			//동작
			for (int i = 0 ; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (maps[i][j] == 1) {
						count += 1;
						bfs(new Pos(i, j));
					}
				}
			}
			bw.write(String.valueOf(count));
			bw.newLine();
		}
		bw.flush();
	}
}