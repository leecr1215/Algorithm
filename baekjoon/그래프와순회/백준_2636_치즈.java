package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0 : 빈칸 1 : 치즈 2 : 공기 치즈
 *
 */

public class 백준_2636_치즈 {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int[][] map;
	static int time; // 치즈가 모두 녹아 없어지는데 걸리는 시간
	static int cnt; // 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여있는 칸의 개수
	static List<Node> airCheeses = new ArrayList<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력받은 map에서 c 표시
		changeAirCheese();

		// 만약 c 밖에 없으면 바로 return
		int cheeseCnt = getCheeseNumber(); // 1 인 치즈 개수 세기
		if (cheeseCnt == 0) {
			cnt = airCheeses.size();
			time++;
		} else {

			// 치즈 녹이기
			while (true) {
				// STEP00. time++
				time++;

				// STEP01. 2번 부분 없애기(치즈 공기부분 없애기)
				deleteAierCheese();

				// STEP02. 치즈 공기 넣기
				changeAirCheese();

				// STEP03. 1인 치즈 있는지 개수 세기
				// 만약 1인 애가 아예 없으면 한 시간이 더 지나면 모두 녹아 없어지는 것임
				// 즉, 이때의 2의 개수를 세서 cnt에 저장
				// time++도 해주기
				// break;
				cheeseCnt = getCheeseNumber();
				if (cheeseCnt == 0) {
					cnt = airCheeses.size();
					time++;
					break;
				}
			}
		}
		System.out.println(time);
		System.out.println(cnt);
	}

	// 1인 치즈의 개수 세기
	private static int getCheeseNumber() {
		int num = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					num++;
				}
			}
		}

		return num;
	}

	// 2번 부분을 0으로 변경
	private static void deleteAierCheese() {
		for (Node cheese : airCheeses) {
			map[cheese.x][cheese.y] = 0;
		}
	}

	private static void changeAirCheese() {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		airCheeses.clear();

		queue.add(new Node(0, 0));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
					// 만약 빈칸일 때는 큐에 넣기!
					if (map[nx][ny] == 0) {
						queue.add(new Node(nx, ny));
						visited[nx][ny] = true;
					}

					// 만약 치즈일 때는 2로 변경해주기! 공기 주입.
					else if (map[nx][ny] == 1) {
						map[nx][ny] = 2;
						airCheeses.add(new Node(nx, ny));
						visited[nx][ny] = true;
					}
				}

			}
		}
	}

}