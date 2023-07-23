package 그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준_2178_미로탐색
 */
public class 백준_2178_미로탐색 {

    static class Node {
        int x;
        int y;
        int cnt; // 칸 수

        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }


    static int N;
    static int M;
    static int[][] map;
    static int minCnt = Integer.MAX_VALUE;

    // visited 대신 map에 2가 있다면 방문했다고 판단
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split("");

            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        bfs();

        System.out.println(minCnt);

    }

    // 상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        map[0][0] = 2;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.x == N-1 && node.y == M-1){
                minCnt = Math.min(minCnt, node.cnt);
                break;
            }

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1){
                    queue.add(new Node(nx, ny, node.cnt+1));
                    map[nx][ny] = 2;
                }
            }

        }
    }
    
}