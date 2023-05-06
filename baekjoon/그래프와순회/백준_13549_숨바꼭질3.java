package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 백준_13549_숨바꼭질3 {
    static int N, K;
	static boolean[] visited;
    private static int answer = Integer.MAX_VALUE;

    private static class Node{
        int value; // 위치. 실제 값
        int level; // 큐에 들어간 level
    
        public Node (int value, int level){
            this.value = value;
            this.level = level;
        }
    }

	public static void main(String[] args)  throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[100_001];
		
		bfs();

        System.out.println(answer);
		
	}

    private static void bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(new Node(N, 0));
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			if(node.value == K) {
				answer = Math.min(answer, node.level);
			}
			
			// X*2 X-1 X+1 
            if(node.value*2 <= 100_000 && !visited[node.value*2]) {
				queue.offer(new Node(node.value*2, node.level));	
                visited[node.value * 2] = true;
            }

            if(node.value-1 >= 0 && !visited[node.value-1]) {
				queue.offer(new Node(node.value-1, node.level+1));
                visited[node.value - 1] = true;
            }
            
            if(node.value+1 <= 100_000 && !visited[node.value+1]) {
                queue.offer(new Node(node.value+1, node.level+1));
                visited[node.value + 1] = true;
            }
		

		}
		
		
	}
}
