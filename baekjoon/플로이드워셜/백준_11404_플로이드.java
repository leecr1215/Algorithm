package 플로이드워셜;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11404_플로이드 {

	static int INF = 9999999;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] distance = new int[n+1][n+1];
		
		// distance INF 로 초기화
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				if(i!=j) {
					distance[i][j] = INF;
				}
			}
		}
		

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			distance[a][b] = Math.min(c, distance[a][b]);
			
		}

		// 플로이드 워셜
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				if(i==k) continue; 
				for(int j = 1; j <= n; j++) {
					if(i==j || j==k) continue;
					
					distance[i][j] = Math.min(distance[i][j], distance[i][k]+distance[k][j]);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(distance[i][j]==INF) {
					System.out.print(0+" ");
				}
				else {
					System.out.print(distance[i][j] + " ");
				}
			}
			System.out.println();
		}

	}
}