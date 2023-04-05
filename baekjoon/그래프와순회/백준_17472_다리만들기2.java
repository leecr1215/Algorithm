package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 색칠 되어있는 건 땅. 즉 섬
 * 다리 건설할거임. 다리 길이는 2 이상
 * 다리 방향은 가로 또는 세로
 * 
 * 지금 땅은 -1로 초기화되어있음
 */

public class 백준_17472_다리만들기2 {
	
	private static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y =y ;
		}
	}
	
	private static class Edge{
		int v1; // 섬 번호
		int v2; // 섬 번호
		int distance; // 다리 거리
		
		public Edge(int v1, int v2, int distance) {
			this.v1 = v1;
			this.v2 = v2;
			this.distance = distance;
		}
	}
	
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static Integer[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] =  Integer.parseInt(st.nextToken()) * -1;
			}
		}
		
		/** STEP01. 섬 별로 번호 넘버링하기 **/
		int num = 0; // 라벨링 된 섬 개수
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j]==-1 && !visited[i][j]) { // 방문 안 한 땅일 때
					islandNumbering(i,j,++num);
				}
			}
		}
		
		// map 출력해보기
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		/** STEP02. 가능한 다리 모두 짓기 **/
		List<Edge> graph = new ArrayList<>(); // 다리 리스트
		makeBridge(graph);

		/** STEP03. 최소 다리 선택 By 크루스칼 MST **/
		parents = new Integer[num+1];
		makeSet();
		
		// union-find
		graph.sort((a,b)->a.distance-b.distance);
		
		int resultDistance = 0;
		
		for(Edge edge: graph) {
//			System.out.println("엣지 : "+ edge.v1+ " "+edge.v2+" "+edge.distance);
			if(union(edge.v1, edge.v2)) {
				resultDistance += edge.distance;
			}
		}
		
		/** STEP04. 모든 섬이 연결 가능한지 확인 **/
//		System.out.println(Arrays.toString(Arrays.copyOfRange(parents, 1, num+1)));
		Set<Integer> set = new HashSet<>();
		
		for(int i = 1; i < parents.length; i++) {
			set.add(findSet(i));
		}
	
		if(set.size() != 1) { // 	부모의 종류가 1개가 아니면 연결 불가능한 것
			System.out.println(-1);
		}else {
			System.out.println(resultDistance);			
		}
		
	}
	
	
	private static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if (rootA == rootB)
			return false;

		parents[rootB] = rootA;
		return true;
	}


	// 부모 찾기
	private static int findSet(int a) {
		if(parents[a]==a) return a;

		return parents[a]= findSet(parents[a]);
	}


	private static void makeSet() {
		for(int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}
	}

	// 다리 짓기
	private static void makeBridge(List<Edge> graph) {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j]!=0) {
					// 상하좌우로 쭉 가서 거리 구하기
					int number = map[i][j]; // 현재 섬의 번호
					
					for(int dir = 0; dir < 4; dir++) {
						int distance = 0; // 다리 길이
						int nx = i;
						int ny = j;
						while(true) {
							nx += dx[dir];
							ny += dy[dir];
					
							
							if(nx < 0 || nx >= N || ny < 0 || ny >= M) break;
							
							if(map[nx][ny]==number) break;
							
							if(map[nx][ny]!=0) {
								// 섬 만남!
								// list에 추가	
								if(distance >= 2) {									
									graph.add(new Edge(number, map[nx][ny], distance));
								}

								break;
							}
							
							distance++;
						}
						
					}
					
				}
			}
		}
		
	}

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	// bfs로 섬 넘버링
	private static void islandNumbering(int x, int y, int num) {
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(new Node(x,y));
		visited[x][y] = true;
		map[x][y] = num;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny]==-1) {
					queue.add(new Node(nx,ny));
					visited[nx][ny] = true;
					map[nx][ny] = num;
				}
			}
		}
		
	}

}