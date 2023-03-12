package 그래프와순회;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1697_숨바꼭질 {
	static int N, K;
	static boolean[] visited;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		visited = new boolean[100_001];
		
		bfs();
		
	}

	private static void bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(N, 0));
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(node.value == K) {
				System.out.println(node.level);
				break;
			}
			
			// X-1 X+1 X*2
			if(node.value-1 >= 0 && !visited[node.value-1]) {
				queue.offer(new Node(node.value-1, node.level+1));	
				visited[node.value-1] = true;
			}
			
			if(node.value+1 <= 100_000 && !visited[node.value+1]) {
				queue.offer(new Node(node.value+1, node.level+1));
				visited[node.value+1] = true;
			}
			
			if(node.value*2 <= 100_000 && !visited[node.value*2]) {
				queue.offer(new Node(node.value*2, node.level+1));	
				visited[node.value*2] = true;
			}

		}
		
		
	}
}

class Node {
	int value; // 위치. 실제 값
	int level; // 큐에 들어간 level

	public Node (int value, int level){
		this.value = value;
		this.level = level;
	}
}
