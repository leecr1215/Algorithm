package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 백준_24479 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] visited;
	static int N, M, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 초기화
		N = Integer.parseInt(st.nextToken()); // 정점의 수
		M = Integer.parseInt(st.nextToken()); // 간선의 수
		int R = Integer.parseInt(st.nextToken()); // 시작 정점

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
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

		cnt = 1;
		visited = new int[N + 1];
		dfs(R);

		for (int i = 0; i < visited.length; i++) {
			if (i != 0)
				System.out.println(visited[i]);
		}
	}

	public static void dfs(int v) {
		visited[v] = cnt;
		for (int i = 0; i < graph.get(v).size(); i++) {
			// 연결된 노드
			int node = graph.get(v).get(i);
			if (visited[node] == 0) { // 방문 안 한 노드
				cnt++;
				dfs(node);
			}
		}
	}
}