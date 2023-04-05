import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플로이드 워셜 사용
public class Solution_5643_키순서 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 학생 수
			int M = Integer.parseInt(br.readLine()); // 키를 비교한 횟수
			
			int[][] dist = new int[N+1][N+1];
			
			// dist를 0으로 초기화
			for(int i = 0; i < N+1; i++) {
				Arrays.fill(dist[i], 0);
			}
			
			// dist[i][j] : i보다 j가 키가 작으면 -1로 표시
			// dist[i][j] : i보다 j가 키가 크면 1로 표시
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				dist[a][b] = -1;
				dist[b][a] = 1;
				
			}
			
			
			// 플로이드 워셜
			for(int k = 1; k < N+1; k++) {
				for(int i = 1; i < N+1; i++) {
					if(i==k) continue;
					for(int j = 1; j < N+1; j++) {
						if(i==j || j==k) continue;
						
						if(dist[i][k]==1 && dist[k][j]==1) {
							dist[i][j] = 1;
							dist[j][i] = -1;
						}
						
					}
				}
			}
			
			// 출력
//			for(int i = 1; i < N+1; i++) {
//				for(int j = 1; j < N+1; j++) {
//					System.out.print(dist[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			// 키 순서를 확정지을 수 있는 건 키가 작은것과 큰 것을 비교한 횟수를 합쳐 N-1개면 가능
			int cnt = 0;
			
			for(int i = 1; i < N+1; i++) {
				int temp = 0;
				
				for(int j = 1; j < N+1; j++) {
					if(dist[i][j]!=0) temp++;
				}
				
				if(temp == N-1) {
					cnt++;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
			
		}
	
	}
}