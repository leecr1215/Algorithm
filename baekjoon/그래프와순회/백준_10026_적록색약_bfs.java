package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 백준_10026_적록색약_bfs {

	static int N;
	static char[][] map;
	static boolean[][] visited;


	// 상하좌우
	final static int[] dx = { -1, 1, 0, 0 };
	final static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		visited = new boolean[N][N];

		// map 입력
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int areaCnt1=0; // 적록색약이 아닌 사람이 본 구역의 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					areaCnt1++;
				}
				// 해당 정점이 처리된 후 초록색을 빨간색으로 변경
				if(map[i][j]=='G') map[i][j] = 'R';
			}
		}

		visited = new boolean[N][N];

		int areaCnt2=0; // 적록색약인 사람이 본 구역의 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					bfs(i,j);
					areaCnt2++;
				}
			}
		}
		
		
		System.out.print(areaCnt1 + " " + areaCnt2);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] color = queue.poll();
			int r = color[0];
			int c = color[1];

			for (int i = 0; i < 4; i++) {
				int nx = r + dx[i];
				int ny = c + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[r][c] == map[nx][ny]) {
					queue.add(new int[] {nx, ny, map[nx][ny]});
					visited[nx][ny] = true;
				}
			}
		}

	}


}
