import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1987_알파벳_비트마스킹 {
	static int R, C;
	static char[][] map;
	static int answer;

	// 상하좌우
	final static int[] dx = { -1, 1, 0, 0 };
	final static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		dfs(0, 0, 1, 1 << (map[0][0] - 'A'));

		System.out.println(answer);

	}

	private static void dfs(int x, int y, int count, int flag) {
		answer = Math.max(answer, count);

		// 상하좌우로 이동
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < R && ny >= 0 && ny < C && (flag & (1 << (map[nx][ny] - 'A'))) == 0) {			
				dfs(nx, ny, count + 1, flag | (1 << (map[nx][ny] - 'A')));		
			}
		}

	}
}
