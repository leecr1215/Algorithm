import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2117_홈방범서비스 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			List<Home> homes = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) homes.add(new Home(i,j));
				}
			}
			
			/** STEP01. 도시 다 덮는 k는 N임 **/
			int K = N+1;
			int maxHome = 0;
			
			/** STEP02. 중심점 지정 **/
			while(K > 0) {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						// 중심점 i,j 지정
						int cnt = 0; // 마름모에 포함되는 집 개수
						
						// 마름모에 포함되는 집의 개수 구하기
						for(Home home : homes) {
							// home과 중심점과의 거리
							int distance = Math.abs(home.x-i)+Math.abs(home.y-j);
							if(distance < K) {
								cnt++;
							}
						}
						
						// 보안회사 수익 구하기 
						// 집 개수 * 비용 - 운영 비용
						int revenue = (cnt*M)-(K*K+(K-1)*(K-1));
//						System.out.println("K: " + K + ", 집 개수: " + cnt + ", 수익: " + revenue);
						if(revenue >= 0) maxHome = Math.max(maxHome, cnt);

					}
				}
				K--;
			}
			System.out.println("#"+t+" "+maxHome);
		}
		
	}
	
	static class Home{
		int x;
		int y;
		
		public Home(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
