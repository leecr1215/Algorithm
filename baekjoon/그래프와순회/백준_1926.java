package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1926 {
	static int n;
	static int m;
	static boolean[][] visited;
	static int[][] pictures;
	static Queue<Node> queue = new LinkedList<>();
	static int max = 0;
	static int pictureNum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[n][m];
		pictures = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				pictures[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 이중포문으로 bfs 시작점 찾기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (pictures[i][j] == 1 && visited[i][j] == false) {
					queue.add(new Node(i, j));
					visited[i][j] = true;
					bfs();
				}
			}
		}
		System.out.println(pictureNum);
		System.out.println(max);

	}

	// pictures[x,y]부터 시작
	public static void bfs() {
		pictureNum++;
		// 상하좌우
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int count = 0;
		while (!queue.isEmpty()) {
			count++;
			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == false && pictures[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.add(new Node(nx,ny));
					
				}
				
			}
		}
		
		max = Math.max(max, count);
	}
}

class Node {
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
