package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 0 : 빈칸
// 1 : 벽
// 2 : 바이러스

public class 백준_14502_연구소 {
	private static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	
	static int[][] map;
	static int N,M;
	static List<Node> blanks = new ArrayList<>();
	static List<Node> viruses = new ArrayList<>();
	static boolean[][] visited;
	static Node[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		selected = new Node[3];
				
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				
				if(temp==0) {
					blanks.add(new Node(i,j));
				}
				else if(temp==2) {
					viruses.add(new Node(i,j));
				}
			}
		}
		
		permutation(0);
		
		System.out.println(max);
	}	
	
	static int max = 0;
	
	// blanks.length 중 3개 뽑기
	public static void permutation(int cnt) {
		if(cnt == 3) {			
			// selected에 벽 세우기
			int[][] copyMap = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				copyMap[i] = map[i].clone();
			}
			
			for(int i = 0; i < 3; i++) {
				Node temp = selected[i];
				copyMap[temp.x][temp.y] = 1;
			}
			
			// 벽 세운 상태에서 바이러스 퍼뜨리기
			// 만약 다음 애가 1이면 걔는 큐에 안 넣음
			int safeArea = bfs(copyMap);
			
			max = Math.max(safeArea, max);
			
			return;
		}
		
		for(int i = 0; i < blanks.size(); i++) {
			Node node = blanks.get(i);
			
			if(visited[node.x][node.y]) continue;
			
			selected[cnt] = node;
			visited[node.x][node.y] = true;
			
			permutation(cnt+1);
			
			visited[node.x][node.y] = false;
		}
		
		
	}

	// 바이러스 퍼뜨리기
	// 다음 애가 0일때만 바이러스 퍼뜨리기. 큐에 넣기
	
	private static int bfs(int[][] copyMap) {
		boolean[][] bfsVisited = new boolean[N][M];
		
		Queue<Node> queue = new ArrayDeque<>();
		
		for(int i = 0; i < viruses.size(); i++) {
			Node virus = viruses.get(i);
			queue.add(virus);
			bfsVisited[virus.x][virus.y] = true;
		}
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = curNode.x + dx[i];
				int ny = curNode.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >=0 && ny < M && copyMap[nx][ny]==0 && !bfsVisited[nx][ny]) {
					queue.add(new Node(nx,ny));
					bfsVisited[nx][ny] = true;
					copyMap[nx][ny] = 2;
				}
			}
		}

		// 0 개수 세서 리턴
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j]==0) cnt++;
			}
		}
		
		return cnt;
		
	}
}