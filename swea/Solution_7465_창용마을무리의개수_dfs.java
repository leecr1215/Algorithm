import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_7465_창용마을무리의개수_dfs {

	static int N, M;
	static int relation[][];
	static boolean visited[];
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 창용 마을에 사는 사람 수
			M = sc.nextInt(); // 서로를 알고 있는 사람의 관계 수

			relation = new int[N+1][N+1];
			visited = new boolean[N+1];
			
			// 관계 표시
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				relation[a][b] = 1;
				relation[b][a] = 1;
			}
			
			result = 0;
			for(int i = 1; i < N+1; i++) {
				if(visited[i]) continue;
				// 방문한 적 없다 -> 누군가의 무리가 되지 않았다.
				dfs(i); // 이 정점부터 시작해서 하나의 무리로 묶어주기
				result++;
			}
			

		}
	}
	
	// dfs 탐색하면서 아는 사람들 모두 하나의 무리로 묶어주기
	static void dfs(int idx) {
		if(!visited[idx]) {
			visited[idx] = true;
			for(int i = 1; i < N+1; i++) {
				if(relation[idx][i]==1 && !visited[i]) dfs(i);
			}
		}
	}

}
