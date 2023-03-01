import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_4963_섬의개수 {
	static int[][] map; // 방문 시 -1로 변경
	static int w, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			map = new int[h][w]; // 지도

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0; // 섬의 개수
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) { // 방문 안 한 땅
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}

	}

	// 위, 아래, 왼, 오, 왼쪽위, 왼쪽아래, 오른쪽위, 오른쪽아래
	final static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
	final static int[] dy = { 0, 0, -1, 1, -1, -1, 1, 1 };

	private static void dfs(int i, int j) {
		map[i][j] = -1; // 방문 처리

		for (int k = 0; k < 8; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];

			if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}

	}
}
