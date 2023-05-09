package 그래프와순회;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;

public class 백준_11779_최소비용구하기2 {
	
	static class Node {
		int num; // 도시번호
		int cost; // 시작점에서 해당 도시까지의 비용
		
		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	
	static int N, M;
	static List<Node>[] graph;
	
	static int[] dist;
	static boolean[] visited;
    static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); //도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		graph = new ArrayList[N+1];
		
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[from].add(new Node(to, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1]; // 도시 N까지의 최소 비용
		visited = new boolean[N+1]; // 도시 N의 방문 여부
		parent = new int[N+1]; // N번째 도시를 오기 바로 전 도시를 저장

		Arrays.fill(dist, INF);
		
		dijkstra(startCity, endCity);
		
        Stack<Integer> path = new Stack<>();
        
        int p = endCity;
        while(p != 0){
            path.add(p);
            p = parent[p];
        }
        
        System.out.println(path.size());

        for(int i = path.size(); i > 0 ; i--){
            System.out.print( path.pop() + " ");
        }

    }


	private static void dijkstra(int startCity, int endCity) {
		dist[startCity] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
		pq.offer(new Node(startCity, 0));
		
		while(!pq.isEmpty()) {
			Node city = pq.poll();
			
			if(visited[city.num]) continue;
			visited[city.num] = true;
           
			for(Node nextCity : graph[city.num]) {
				if(dist[nextCity.num] > dist[city.num] + nextCity.cost) {
					dist[nextCity.num] = dist[city.num] + nextCity.cost;
					pq.offer(new Node(nextCity.num, dist[nextCity.num]));
                    parent[nextCity.num] = city.num;
				}
			}

		}
		System.out.println(dist[endCity]);
	
	}
}