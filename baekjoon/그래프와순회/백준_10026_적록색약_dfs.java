package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_10026_적록색약_dfs {

	static int N;
	static String[][] map;
	static boolean[][] visited;
	static int areaCnt1; // 적록색약이 아닌 사람이 본 구역의 개수
	static int areaCnt2; // 적록색약인 사람이 본 구역의 개수

	// 상하좌우
	final static int[] dx = { -1, 1, 0, 0 };
	final static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new String[N][N];
		visited = new boolean[N][N];

		// map 입력
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}

		// 적록색약이 아닌 사람의 구역 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;
				dfs(i, j, map[i][j]);
				areaCnt1++;
			}
		}
		
		for(int i = 0; i < N; i++) {			
			Arrays.fill(visited[i], false);
		}
		
		// R을 다 G로 바꾸기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].equals("R")) {
					map[i][j] = "G";
				}
			}
		}
		
		// 적록색약인 사람의 구역 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j])
					continue;
				dfs(i, j, map[i][j]);
				areaCnt2++;
			}
		}


		System.out.print(areaCnt1 + " " + areaCnt2);
	}

	/**
	 * 적록색약이 아닌 사람이 봤을 때
	 * @param x
	 * @param y
	 * @param color
	 */
	private static void dfs(int x, int y, String color) {
		visited[x][y] = true;
		
		// 4방 탐색
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx >=0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny].equals(color)) {
				dfs(nx, ny, color);
			}
		}
	}


}
