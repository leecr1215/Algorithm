package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 블로그
// https://velog.io/@suk13574/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Java%EB%8B%A4%EC%9D%B5%EC%8A%A4%ED%8A%B8%EB%9D%BCDijkstra-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98

public class 백준_1916_최소비용구하기 {
	
	final static int INF = Integer.MAX_VALUE;
	
	private static class Node {
		int vertex; // 정점 번호
		int distance; // 거리
		
		public Node(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 도시의 개수
		int M = Integer.parseInt(br.readLine()); // 버스의 출발 도시의 번호
		
		// 각 도시->도시의 비용을 저장하는 리스트
		List<Node>[] graph = new ArrayList[N+1];
		
		for(int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken()); 
			int end = Integer.parseInt(st.nextToken()); 
			int cost = Integer.parseInt(st.nextToken()); 
			
			graph[start].add(new Node(end, cost));
			
		}
		
		st = new StringTokenizer(br.readLine());
		
		int startNode = Integer.parseInt(st.nextToken());
		int endNode= Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N+1]; // 도시의 방문 여부
		int[] dist = new int[N+1]; // 출발지에서 index 도시까지 오는 최소 거리
		
		Arrays.fill(dist, INF);
		
		// 시작 노드를 0으로 변경
		dist[startNode] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
		pq.offer(new Node(startNode, 0));
		
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(visited[node.vertex]) continue;
			visited[node.vertex] = true;
			
			// 현재 노드와 연결된 정점과 비교
			for(Node nextNode : graph[node.vertex]) {
				if(dist[nextNode.vertex] > dist[node.vertex]+nextNode.distance) {
					
					dist[nextNode.vertex] = dist[node.vertex]+nextNode.distance;
					
					pq.offer(new Node(nextNode.vertex, dist[nextNode.vertex]));
				}
			}
			
		}
		
		System.out.println(dist[endNode]);
		
	}
}
