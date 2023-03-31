package 동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
		
		int[] weights = new int[N+1];
		int[] values = new int[K+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		// dp[i][w] : 버틸 수 있는 무게가 w일 때, 0~i개의 물품으로 만들 수 있는 최대 가치
		int[][] dp = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			for(int w = 1; w <= K; w++) {
				if(weights[i] > w) { // 아이템의 무게 > 현재 버틸 수 있는 무게
					dp[i][w] = dp[i-1][w];
				}
				else {
					dp[i][w] = Math.max(dp[i-1][w], values[i] + dp[i-1][w-weights[i]]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}
}