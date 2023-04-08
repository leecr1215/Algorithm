package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 백준_1941_소문난칠공주 {
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static char[][] map = new char[5][5];
	static Node[] picked = new Node[7];
	static int result;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		combination(0,0);
		
		System.out.println(result);
	}

	/**
	 * 0(0,0) 1(0,1) 2(0,2) 3(0,3) 4(0,4)
	 * 5(1,0) 6(1,1) 7(1,2) 8 9
	 * 10 11 12 13 14
	 * 15 16 17 18 19 20
	 * 21 22 23 24 25
	 * 
	 * 
	 */
	private static void combination(int cnt, int start) {
		if(cnt == 7) {
			// 이다솜파가 몇명인지 체크
			int sSum = findS();

			// 이다솜파가 4명 이상일때			
			if(sSum >= 4) {
				// 모두 연결되어있는지 확인
				// bfs로 연결된 개수 count
				int connectNum = getConnectNum();
				
				if(connectNum==7) result++;			
			}

			return;
		}
		
		for(int i = start; i < 25; i++) {
			int r = i / 5;
			int c = i % 5;
			
//			System.out.println("r : "+r+", c:"+c);
			
			picked[cnt] = new Node(r,c);
			combination(cnt+1, i+1);
		}
		
	}

	/**
	 * picked에서 애들이 다 연결되어있는지 확인
	 * @return
	 */
	private static int getConnectNum() {
		int cnt = 0;
		
		int[][] arr = new int[5][5];
		
		// arr에 picked만 1로 채우고 나머지는 0으로 채우기
		for(Node p : picked) {
			arr[p.x][p.y] = 1;
		}
		
		
//		System.out.println("===================");
//		for(int i = 0; i < 5; i++) {
//			for(int j = 0; j < 5; j++) {
//				System.out.print(arr[i][j] + "");
//			}
//			System.out.println();
//		}
//		
//		if(map[0][0] == 0 &&
//				map[0][1] == 0 &&	
//				map[0][2] == 0 &&
//				map[0][3] == 0 &&
//				map[0][4] == 0)
//			System.out.println("");
		
		// BFS로 연결된거 확인!
		Queue<Node> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[5][5];
		
		queue.add(new Node(picked[0].x, picked[0].y));
		visited[picked[0].x][picked[0].y] = true;
		cnt++;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(isInRange(nx, ny) && !visited[nx][ny] && arr[nx][ny]==1) {
					queue.add(new Node(nx,ny));
					visited[nx][ny] = true;
					cnt++;
				}
			}
			
		}
	
		
		return cnt;
	}

	/**
	 * 이다솜파 몇명인지 수 세기
	 * @return
	 */
	private static int findS() {
		int cnt = 0;
		for(int i = 0 ; i < picked.length; i++) {
			int x = picked[i].x;
			int y = picked[i].y;
			if(map[x][y]=='S') cnt++;
		}
		return cnt;
	}
	
	/**
	 * 경계안에 있는지 확인
	 */
	private static boolean isInRange(int nx, int ny) {
		return nx >= 0 && nx < 5 && ny >= 0 && ny < 5;
	}
}