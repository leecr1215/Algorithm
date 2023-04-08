package level3;

public class 등굣길 {
	public static void main(String[] args) {
		int[][] puddles = { { 2, 2 } };
		System.out.println(solution(4, 3, puddles));
	}

	public static int solution(int m, int n, int[][] puddles) {
		int[][] map = new int[n + 1][m + 1];

		// 웅덩이를 -1로 변경해주기
		for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][1]][puddles[i][0]] = -1;
		}

		map[1][1] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == -1)
					continue;

				if (map[i - 1][j] != -1) { // 내 윗 칸이 웅덩이가 아닐때
					map[i][j] += map[i - 1][j] % 1000000007;
				}
				if (map[i][j - 1] != -1) { // 내 왼쪽 칸이 웅덩이가 아닐때
					map[i][j] += map[i][j - 1] % 1000000007;
				}

			}
		}

		return map[n][m] % 1000000007;
	}

}