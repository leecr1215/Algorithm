package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1260_DFS와BFS {
	static int N, M; // 정점, 간선, 정점번호
	static boolean[] visited;
	static List<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken());

		// 초기화
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		// 노드 연결
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		// 그래프 오름차순 정렬
		for (int i = 0; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}
		
		visited = new boolean[N+1];
		
		dfs(V);
		System.out.println();
		
		Arrays.fill(visited, false);
		
		bfs(V);
	}

	private static void bfs(int V) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
			
			// node랑 연결된 애들 다 queue에 넣기
			// 방문하지 않은 애만!
			for(int i = 0; i < graph.get(node).size(); i++) {
				int next = graph.get(node).get(i); 
				if(visited[next]) continue;
				queue.add(next);
				visited[next] = true;
			}
			
		}
		
		
	}

	/**
	 * graph[1] -> 2, 3, 4
	 * graph[2] -> 4
	 * graph[3] -> 4
	 * 
	 * @param V : 시작 정점 노드
	 */
	private static void dfs(int V) {
		visited[V] = true;
		System.out.print(V + " ");
		
		// 정점 V와 연결된 애들 dfs 돌리기
		for(int i = 0; i < graph.get(V).size(); i++) {
			int next = graph.get(V).get(i);
			if(visited[next]) continue;
			dfs(next);
		}
		
	}
}
