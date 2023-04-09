package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class 백준_16919_봄버맨2 {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	static int R, C, N;
	static char[][] map;
	static List<Node> booms = new ArrayList<>();
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); // 시간

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();

			for (int j = 0; j < C; j++) {
				char c = line.charAt(j);
				map[i][j] = c;

				if (c == 'O') {
					booms.add(new Node(i, j));
				}
			}
		}
		// 1초인 경우
		if(N==1) {
			printMap();
			return;
		}

		// 만약 원하는 시간이 짝수라면 걍 무조건 다 폭탄으로 채워져있는 상태임
		if (N % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print('O');
				}
				System.out.println();
			}
			return;
		}
		
		// N값 변경
		N = N % 4 + 4;

		/** STEP01. 1초후 **/
		// 아무일도 일어나지 않고 시간만 감
		N--;
		
		while (true) {
			if (N == 0) break;

			/** STEP02. 2초후 **/
			// 모든 격자판에 폭탄 채움
			// 시간 경과
			fillBooms();
			N--;
			
			if (N == 0) break;

			/** STEP03. 3초후 **/
			// 전에 심겨져 있던 폭탄(booms) 펑
			// booms clear후, 남은 폭탄을 다시 booms에 저장하기
			// 시간 경과
			doBoom();
			N--;
			
			if (N == 0) break;
		}
		
		// 최종 상태 출력
		printMap();
		
		
	}

	/**
	 * 3초 전에 있던 폭탄 터트리는 함수.
	 * 
	 * 폭탄 터지면 ?
	 * - 지금 있는 자리 빈 칸됨
	 * - 인접한 곳도 빈 칸됨 (폭탄이든 뭐든 상관없음)
	 * 
	 * 폭탄 터트린 후?
	 * - booms clear
	 * - 남은 폭탄을 다시 booms에 저장하기
	 */
	private static void doBoom() {
		Queue<Node> queue = new ArrayDeque<>(); 
		
		// booms에 있던 자리 큐에 넣기
		for(Node boom : booms) {
			queue.add(boom);
			map[boom.x][boom.y] = '.'; // 빈칸으로 변경
		}
		
		/** 폭탄 터뜨리기 **/
		while(!queue.isEmpty()) {
			Node boom = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = boom.x + dx[i];
				int ny = boom.y + dy[i];
				
				if(isInRange(nx, ny)) {
					map[nx][ny] = '.';
				}
				
			}
		}
		
		/** 폭탄 터뜨린 후 **/
		// booms clear 시키기
		// 지금 남아있는 폭탄 booms에 저장시키기
		booms.clear();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'O') {
					booms.add(new Node(i, j));
				}
			}
		}
	}

	/**
	 * 모든 격자판에 폭탄 채우는 함수
	 * 
	 */
	private static void fillBooms() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = 'O';
			}
		}
	}
	
	/**
	 * 경계 안에 있는지 확인하는 함수
	 */
	private static boolean isInRange(int nx, int ny) {
		return nx >= 0 && nx < R && ny >= 0 && ny < C;
	}
	
	/**
	 * 현재 map 상태 출력
	 * 
	 */
	private static void printMap() {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}