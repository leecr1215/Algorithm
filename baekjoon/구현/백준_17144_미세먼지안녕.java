import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_17144_미세먼지안녕 {
	static int R;
	static int C;
	static int T; // 주어진 시간
	static int[][] A;
	static Queue<Dust> queue = new ArrayDeque<>();
	static List<Cleaner> airCleaner = new ArrayList<>(); // 공기

	// 상하좌우
	final static int[] dx = { -1, 1, 0, 0 };
	final static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		A = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int dust = Integer.parseInt(st.nextToken());
				A[i][j] = dust;

				if(dust == -1){
					airCleaner.add(new Cleaner(i, j));
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			bfs();
		}
		
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(A[i][j] + " ");
//			}
//			System.out.println();
//		}
		

		int sum = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (A[i][j] > 0)
					sum += A[i][j];
			}
		}

		System.out.println(sum);
	}

	private static void bfs() {
		
		/** step0. 미세먼지 queue에 넣기 **/
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if (A[i][j] > 0)
					queue.add(new Dust(i, j, A[i][j]));
			}
		}
		
		
		/** step01. 미세먼지 확산 **/
		while (!queue.isEmpty()) {
			Dust dust = queue.poll();
			
			int x = dust.x;
			int y = dust.y;
			int amount = dust.amount;

			int count = 0; // 확산된 방향의 개수

			// 사방 탐색
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && nx < R && ny >= 0 && ny < C && A[nx][ny] != -1) {
					A[nx][ny] += amount / 5;
//					queue.add(new Dust(nx, ny, A[nx][ny]));
					count++;
				}
			}

			A[x][y] -= (amount / 5) * count;

		}
		

		/** step02. 공기 청정기 작동 **/
		runCleaner();

		
	}

	// 위쪽의 방향 : 상 우 하 좌
	final static int[] dx1 = { -1, 0, 1, 0 };
	final static int[] dy1 = { 0, 1, 0, -1 };

	// 아래쪽의 방향 : 하 우 상 좌
	final static int[] dx2 = { 1, 0, -1, 0 };
	final static int[] dy2 = { 0, 1, 0, -1 };

	private static void runCleaner() {
		/** 위쪽 공기 청정기 돌리기 : 반시계 순환 **/
		// start 점은 청정기[1]
		int d = 0;

		int x = airCleaner.get(0).x;
		int y = airCleaner.get(0).y;

		while (d < 4) {
			
			int nx = x + dx1[d];
			int ny = y + dy1[d];

			if (nx >= 0 && nx <= airCleaner.get(0).x && ny >= 0 && ny < C) {
		
				if (A[nx][ny] != -1 && A[x][y] != -1) {
					A[x][y] = A[nx][ny];
				}
				x = nx;
				y = ny;
			} else {
				d++;
			}

		}

		// 청정기 (x,y+1)에 0 넣기
		A[airCleaner.get(0).x][airCleaner.get(0).y+1] = 0;

		/** 아래쪽 공기 청정기 돌리기 : 시계 순환 **/
		// start 점은 청정기[2]
		d = 0;

		x = airCleaner.get(1).x;
		y = airCleaner.get(1).y;

		while (d < 4) {
			int nx = x + dx2[d];
			int ny = y + dy2[d];

			if (nx >= airCleaner.get(1).x && nx < R && ny >= 0 && ny < C) {
				if (A[nx][ny] != -1 && A[x][y] != -1) {
					A[x][y] = A[nx][ny];
				}
				x = nx;
				y = ny;
			}  else {
				d++;
			}

		}

		// 청정기 (x,y+1)에 0 넣기
		A[airCleaner.get(1).x][airCleaner.get(1).y+1] = 0;

	}

	static class Dust {
		int x;
		int y;
		int amount;

		public Dust(int x, int y, int amount) {
			this.x = x;
			this.y = y;
			this.amount = amount;
		}
	}

	static class Cleaner {
		int x;
		int y;

		public Cleaner(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Cleaner [x=" + x + ", y=" + y + "]";
		}
	}
}
