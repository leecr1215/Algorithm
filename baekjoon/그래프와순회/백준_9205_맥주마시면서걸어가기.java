package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_9205_맥주마시면서걸어가기 {
    static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static final int INF = 9999999;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			// 노드 개수 : N+2
			int N = Integer.parseInt(br.readLine()); // 편의점 개수
			
			// 0번 노드 : 집
			// 1~N번 노드 : 편의점
			// N+1번 노드 : 페스티벌
			Node[] coordinates = new Node[N+2];
			
			for(int i = 0; i < N+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				coordinates[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			int[][] dist = new int[N+2][N+2];
			
			
			// dist 채우기
			for(int i = 0; i < N+2; i++) {
				for(int j = 0; j < N+2; j++) {
					Node node1 = coordinates[i];
					Node node2 = coordinates[j];
					
					int distance = Math.abs(node1.x-node2.x)+Math.abs(node1.y-node2.y);
					
					if(distance <= 1000) {
						dist[i][j] = 1;
					}else {
						dist[i][j] = INF;
					}
				}
			}
			
			// 플로이드 워셜
			for(int k = 0; k < N+2; k++) { // 경유지
				for(int i = 0; i < N+2; i++) { // 출발지
					if(i==k) continue;
					for(int j = 0; j < N+2; j++) { // 도착지
						if(i==j || j==k) continue;
						dist[i][j]= Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}

			String result = dist[0][N+1] == INF ? "sad" : "happy"; 
			System.out.println(result);
			
		}
	}
}
