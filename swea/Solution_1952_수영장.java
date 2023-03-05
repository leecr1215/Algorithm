import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {

	static int min; // 최소 비용
	static int[] costs = new int[4]; // 하루, 1달, 3달, 1년 사용권 가격
	static int[] months = new int[12]; // 각 달 별 이용할 횟수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				costs[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				months[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;

			dfs(0, 0);
			
			// 1년 값이랑 비교
			min = Math.min(min, costs[3]);
			
			System.out.println("#"+t+" "+min);
		}

	}

	/**
	 * 
	 * @param cnt : 현재 달
	 * @param sum : 비용 합계
	 */
	private static void dfs(int cnt, int sum) {
		// 12달을 다 확인했으면 return
		if(cnt >= 12) {
			// 최소 비용보다 작으면 비용갱신
			min = Math.min(min, sum);
			return;
		}

		// 이용 횟수가 0회면 그 달은 합계 패스
		if (months[cnt] == 0) {
			dfs(cnt + 1, sum);
		} else {
			// 하루
			dfs(cnt + 1, sum + costs[0] * months[cnt]);

			// 한 달
			dfs(cnt + 1, sum + costs[1]);

			// 세 달
			dfs(cnt + 3, sum + costs[2]);

		}
	}
}
