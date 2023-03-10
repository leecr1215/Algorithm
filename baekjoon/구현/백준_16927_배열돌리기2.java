package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열돌리기 1먼저 해보기
 * 
 * @author SSAFY
 *
 */
public class 백준_16927_배열돌리기2 {
	static int N, M, R;
	static int[][] A;

	// 우 하 좌 상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken()); // R번 회전
		
		// 배열 입력
		A = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		rotate();
		
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void rotate() {

		int sCount = Math.min(N, M) / 2;
		for (int s = 1; s <= sCount; s++) {
			
			// 필요없는 회전 제거
			int realR = R % (2 * (M - 2 * s + 1) + 2 * (N - 2 * s + 1)); 
			
			for(int i = 0; i < realR; i++) {
				int temp = A[s][s]; // 시작 점 값
				int idx = 0; // 방향 인덱스
				
				int x = s;
				int y = s;
				
				while(idx < 4) {
					
					int nx = x + dx[idx];
					int ny = y + dy[idx];
					
					if(nx >= s && nx <= N-s+1 && ny >= s && ny <= M-s+1) {
						A[x][y] = A[nx][ny];
						x = nx;
						y = ny;
					}else {
						idx++;
					}
					
				}
				
				// 시작점 값을 시작점 바로 아래 위치에 넣기
				A[s+1][s] = temp;
			}
			
		}

	}
}