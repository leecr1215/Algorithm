package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * . : 비어있는 곳 * : 물이 있는 곳 X : 돌이 있는 곳 D : 비버의 굴 S : 고슴도치의 위치
 *
 * 고슴도치는 비버의 굴로 가는게 목표 물은 사방으로 확장 (빈칸일 때) 고슴도치는 사방으로 이동 (빈칸일때) 물 먼저!
 *
 * 
 */
public class 백준_3055_탈출 {

	static class Node {
		int x;
		int y;
		int distance;

		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}

	static int R, C;
	static char[][] map;
	static Node hedgehogLocation; // 고슴도치의 위치 저장
	static Node caveLocation; // 비버의 굴 위치 저장
	static List<Node> waters = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();

			for (int j = 0; j < C; j++) {
				char c = str.charAt(j);
				map[i][j] = c;

				if (c == 'S') {
					hedgehogLocation = new Node(i, j, 0);
				} else if (c == '*') {
					waters.add(new Node(i, j, 0));
				} else if(c=='D') {
					caveLocation = new Node(i,j,0);
				}
			}

		}

		
		// map 출력해보기
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

		bfs();

		if(caveLocation.distance == 0) {
			System.out.println("KAKTUS");
		}else {			
			System.out.println(caveLocation.distance);
		}

	}

	/**
	 * 물 먼저 이동 시켜야함
	 */
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void bfs() {
		boolean[][] visited = new boolean[R][C];

		// 고슴도치 이동용 큐
		Queue<Node> hedgehogQueue = new ArrayDeque<>();
		hedgehogQueue.add(hedgehogLocation);
		visited[hedgehogLocation.x][hedgehogLocation.y] = true;

		// 물 이동용 큐
		Queue<Node> waterQueue = new ArrayDeque<>();
		for (Node w : waters) {
			waterQueue.add(w);
			visited[w.x][w.y] = true;
		}

		while (!hedgehogQueue.isEmpty() || !waterQueue.isEmpty()) {
			/** 물 먼저 이동 **/
			int waterSize = waterQueue.size();
			
			while (waterSize > 0) {
				Node water = waterQueue.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = water.x + dx[i];
					int ny = water.y + dy[i];
					
					if(isInRange(nx,ny) && !visited[nx][ny] && map[nx][ny]=='.') {
						waterQueue.add(new Node(nx,ny,water.distance+1));
						visited[nx][ny] = true;
					}
				}
				waterSize--;
				
			}
			
			/** 고슴도치 이동 이동 **/
			int hedgehogSize = hedgehogQueue.size();
			while (hedgehogSize > 0) {
				Node hedgehog = hedgehogQueue.poll();
				
				if(hedgehog.x == caveLocation.x && hedgehog.y == caveLocation.y) {
					caveLocation.distance = hedgehog.distance;
					
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = hedgehog.x + dx[i];
					int ny = hedgehog.y + dy[i];
					
					if(isInRange(nx, ny) && !visited[nx][ny] && (map[nx][ny]=='.' || map[nx][ny]=='D')) {
						hedgehogQueue.add(new Node(nx,ny,hedgehog.distance+1));
						visited[nx][ny] = true;
					}
				}
				hedgehogSize--;
			}
		}

	}
	
	private static boolean isInRange(int nx, int ny) {
		return nx >= 0 && nx < R && ny >=0 && ny < C;
	}
}