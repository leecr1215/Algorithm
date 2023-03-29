package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 일단 순열 고
 * 
 * @author SSAFY
 *
 */
public class 백준_10971_외판원순회2 {

	static int N;
	static boolean[] visited;
	static int[][] cost;
	static int[] selected; // 선택한 도시

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		visited = new boolean[N];
		cost = new int[N][N];
		selected = new int[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		permutation(1);

		System.out.println(min);
	}

	static int min = Integer.MAX_VALUE;

	private static void permutation(int cnt) {
		if (cnt == N) {
			selected[N] = selected[0];
//			System.out.println(Arrays.toString(selected));
			
			// 합
			int sum = 0;

			for (int i = 0; i < N; i++) {
				if (cost[selected[i]][selected[i + 1]] == 0) {
					return;
				}
				sum += cost[selected[i]][selected[i + 1]];
			}
			
			min = Math.min(sum, min);
			return;
		}

		for (int i = 1; i < N; i++) {
			if (visited[i])
				continue;
			selected[cnt] = i;
			visited[i] = true;

			permutation(cnt + 1);

			visited[i] = false;
		}
	}
}
