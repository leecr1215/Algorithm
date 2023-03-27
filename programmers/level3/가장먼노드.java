package level3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][] {{3, 6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}}));
    }

    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    
    public static int solution(int n, int[][] edge) {
        
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge.length; i++){
            int node1 = edge[i][0];
            int node2 = edge[i][1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        visited = new boolean[n+1];
        
        int answer = bfs(n);

        return answer;
    }
    private static int bfs(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;

        int[] distances = new int[n+1];

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int i = 0; i < graph.get(node).size(); i++){
                int nextNode = graph.get(node).get(i);
                
                if(!visited[nextNode]){
                    queue.add(nextNode);
                    visited[nextNode] = true;
                    distances[nextNode] = distances[node]+1;
                }
            }
        }

        System.out.println(Arrays.toString(distances));
        
        Arrays.sort(distances);

        int max = distances[distances.length-1];
        int cnt = 0;

        for(int d: distances){
            if(max == d) cnt++;
        }

        return cnt;
    }
}
