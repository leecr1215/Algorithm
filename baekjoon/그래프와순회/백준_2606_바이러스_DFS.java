package 그래프와순회;


import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_2606_바이러스_DFS {

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

		dfs(1);

		System.out.println(cnt);
	}

	private static void dfs(int startNode) {
		visited[startNode] = true;
		
		for (int i = 0; i < graph.get(startNode).size(); i++) {
			int nextNode = graph.get(startNode).get(i);
			
			if (!visited[nextNode]) {
				dfs(nextNode);
				cnt++;
			}
		}
	}

}