import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14890_경사로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int res = 0;

		for (int i = 0; i < n; i++) {
			// 하나의 행에 대한 활주로 건설 가능 검사
			boolean check = true;
			// 경사로가 지어져있는지 확인
			boolean[] visited = new boolean[n];

			outer: for (int j = 1; j < n; j++) {

				int diff = map[i][j] - map[i][j - 1];

				// 같으면 다음칸 비교
				if (diff == 0)
					continue;

				// 2 이상 차이가 나면 무조건 불가능하므로 검사를 종료한다.
				if (Math.abs(diff) >= 2) {
					check = false;
					break outer;
				}

				if (diff == 1) {
					// 오르막길
					if (visited[j - 1]) {						
						check = false;
						break outer;
					}

					for (int k = 2; k <= x; k++) {
						if (j - k < 0 || map[i][j - k + 1] != map[i][j - k] || visited[j - k]) {
							// k의 길이만큼 평평하지 않으면 불가능
							check = false;
							break outer;
						}
					}
					// 경사로 표시해주기
					if (check) {
						for (int k = 1; k <= x; k++) {
							visited[j - k] = true;
						}
					}
				} else if (diff == -1) {
					// 내리막길
					for (int k = 1; k < x; k++) {
						if (j + k >= n || map[i][j + k - 1] != map[i][j + k] || visited[j + k]) {
							// k의 길이만큼 평평하지 않으면 불가능
							check = false;
							break outer;
						}
					}
					// 경사로 표시해주기
					if (check) {
						for (int k = 0; k < x; k++) {
							visited[j + k] = true;
						}
					}
				}
			}
			if (check) {
				res++;
			}
		}

		for (int j = 0; j < n; j++) {
			// 각 열에 대한 활주로 건설 가능 여부
			boolean check = true;

			boolean[] visited = new boolean[n];
			outer: for (int i = 1; i < n; i++) {

				int diff = map[i][j] - map[i - 1][j];

				// 같으면 다음칸 비교
				if (diff == 0)
					continue;

				// 2 이상 차이가 나면 무조건 불가능하므로 검사를 종료한다.
				if (Math.abs(diff) >= 2) {
					check = false;
					break outer;
				}

				// 오르막길
				if (diff == 1) {
					
					if (visited[i - 1]) {						
						check = false;
						break outer;
					}
					
					for (int k = 2; k <= x; k++) {
						// k의 길이만큼 평평하지 않으면 불가능
						if (i - k < 0 || map[i - k + 1][j] != map[i - k][j] || visited[i - k]) {
							check = false;
							break outer;
						}
					}
					// 경사로 표시해주기
					if (check) {
						for (int k = 1; k <= x; k++) {
							visited[i - k] = true;
						}
					}
				}
				// 내리막길
				else {
					for (int k = 1; k < x; k++) {
						// k의 길이만큼 평평하지 않으면 불가능
						if (i + k >= n || map[i + k - 1][j] != map[i + k][j] || visited[i + k]) {
							check = false;
							break outer;
						}

					}
					// 경사로 표시해주기
					if (check) { // 경사로 표시해주기
						for (int k = 0; k < x; k++) {
							visited[i + k] = true;
						}
					}
				}
			}
			if (check) {
				res++;
			}
		}
		System.out.println(res);

	}
}