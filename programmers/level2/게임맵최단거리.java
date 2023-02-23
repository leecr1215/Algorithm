import java.util.*;

public class 게임맵최단거리 {
    static int count;
    static boolean[][] visited;
    static int n,m;
    
    // 상하좌우
    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};
    
    public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        visited[0][0] = true;
        bfs(maps);
            
        return count == 0 ? -1 : count;
    }
    
    private static void bfs(int[][] maps){
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0,0,1));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            if(node.x == n-1 && node.y == m-1){
                count = node.distance;
                break;
            }

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new Node(nx, ny, node.distance + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        
    }
    public static void main(String[] args) {
		System.out.println(solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
	}
}

class Node {
    int x;
    int y;
    int distance;
    
    public Node(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + ", distance=" + distance + "]";
	}
}