package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_24444_알고리즘수업_너비우선탐색1 {
    static int N,M;
    static int[] result;
    static boolean[] visited;
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 정점 수 
        M = Integer.parseInt(st.nextToken()); // 간선 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        result = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < N+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 오름차순 정렬
        for(int i = 1; i < N+1; i++){
            Collections.sort(graph.get(i));
        }

        bfs(R);

        for(int i = 1; i <= N; i++){
            if(visited[i]) System.out.println(result[i]);
            else System.out.println(0);
        }

    }

    /**
     * 
     * @param r : 시작 정점
     */
    private static void bfs(int r) {
        int cnt = 1;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(r);
        visited[r] = true;
        result[r] = cnt++;

        while(!queue.isEmpty()){
            int vertex = queue.poll();

            for(int i = 0; i < graph.get(vertex).size(); i++){
                int next = graph.get(vertex).get(i);
                if(visited[next]) continue;
                queue.add(next);
                visited[next] = true;
                result[next] = cnt++;
            }
        }
    }
}

