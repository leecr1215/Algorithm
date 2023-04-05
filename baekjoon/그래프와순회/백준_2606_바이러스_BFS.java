package 그래프와순회;

import java.util.List;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_2606_바이러스_BFS {

	static int N, M;
	static List<List<Integer>> graph = new ArrayList<>();
	static int cnt;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		M = Integer.parseInt(br.readLine()); // 쌍의 수

		visited = new boolean[N + 1];

		// graph 초기화
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int computer1 = Integer.parseInt(st.nextToken());
			int computer2 = Integer.parseInt(st.nextToken());

			graph.get(computer1).add(computer2);
			graph.get(computer2).add(computer1);
		}

		bfs(1);

		System.out.println(cnt);
	}

	private static void bfs(int startNode) {
		Queue<Integer> queue = new ArrayDeque<Integer>();

		queue.add(startNode);
		visited[startNode] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int i = 0; i < graph.get(node).size(); i++) {
				int nextNode = graph.get(node).get(i);

				if (!visited[nextNode]) {
					queue.add(nextNode);
					cnt++;
					visited[nextNode] = true;
				}
			}
		}
	}
}