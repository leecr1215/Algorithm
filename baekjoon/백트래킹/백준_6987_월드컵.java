package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_6987_월드컵 {
	static int[][] input;
	static int[][] map;

	static int compareCheck;

	static Game[] games = new Game[15]; // 총 15개의 게임

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int t = 0; t < 4; t++) {
			compareCheck = 0;
			st = new StringTokenizer(br.readLine());

			input = new int[6][3];
			map = new int[6][3];

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int idx = 0;
			for (int i = 0; i < 6; i++) {
				for (int j = i + 1; j < 6; j++) {
					games[idx++] = new Game(i, j);
				}
			}

			dfs(0);

			System.out.print(compareCheck + " ");

		}
	}

	private static void dfs(int round) {
		if (round == 15) {
			if(compareCheck == 0) {				
				compare();
			}
			return;
		}

		// country1이 이긴 경우
		if (map[games[round].country1][0] <= input[games[round].country1][0]) {
			map[games[round].country1][0]++;
			map[games[round].country2][2]++;
			dfs(round + 1);

			map[games[round].country1][0]--;
			map[games[round].country2][2]--;
		}

		// 무승부
		if (map[games[round].country1][1] <= input[games[round].country1][1]) {
			map[games[round].country1][1]++;
			map[games[round].country2][1]++;
			dfs(round + 1);

			map[games[round].country1][1]--;
			map[games[round].country2][1]--;
		}

		// country1이 진 경우
		if (map[games[round].country1][2] <= input[games[round].country1][2]) {
			map[games[round].country1][2]++;
			map[games[round].country2][0]++;
			dfs(round + 1);

			map[games[round].country1][2]--;
			map[games[round].country2][0]--;
		}

	}

	private static void compare() {
		// 주어진 예제와 같은지 확인
		// 같으면 sb에 1 넣기
		boolean check = true;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[i][j] != input[i][j])
					check = false;
			}
		}

		if (check)
			compareCheck = 1;
	}

}

class Game {
	int country1;
	int country2;

	public Game(int country1, int country2) {
		this.country1 = country1;
		this.country2 = country2;
	}

//	@Override
//	public String toString() {
//		return "Game [country1=" + country1 + ", country2=" + country2 + "]";
//	}
}