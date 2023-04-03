import java.io.IOException;
import java.util.Scanner;

public class Solution_1263_사람네트워크2 {
    static final int INF = 9999999;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 정점 수

			int[][] dist = new int[N + 1][N + 1];
			int[] cc = new int[N + 1];

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					dist[i][j] = sc.nextInt();
					if (i != j && dist[i][j] == 0) {// 자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
						dist[i][j] = INF;
					}
				}
			}

			// 플로이드 워셜
			for (int k = 1; k < N + 1; k++) { // 경유지
				for (int i = 1; i < N + 1; i++) { // 출발지
					if (i == k)
						continue; // 출발지와 경유지가 같다면 pass
					for (int j = 1; j < N + 1; j++) {
						if (j == k || i == j)
							continue;
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}

			// cc에 값 넣기
			for (int i = 1; i < N + 1; i++) {
				int sum = 0;
				for (int j = 1; j < N + 1; j++) {
					sum += dist[i][j];
				}
				cc[i] = sum;
			}

			// cc값 중 최소값 구하기
			int min = INF;
			for (int i = 1; i < N + 1; i++) {
				if (min > cc[i]) {
					min = cc[i];
				}
			}

			System.out.println("#" + t + " " + min);

		}

	}
}
