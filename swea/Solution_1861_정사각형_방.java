import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1861_정사각형_방 {
	static int roomNum; // 이동할 수 있는 방의 개수가 최대인 방에 적힌 수
	static int maxRoom; // 이동할 수 있는 방의 최대 개수
	static int N; // 방의 넓이
	static int[][] rooms; // 방 배열

	static Queue<Room> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			queue = new ArrayDeque<>();
			N = sc.nextInt();

			roomNum = N * N;
			maxRoom = 0;

			rooms = new int[N][N];
//			visited = new boolean[N][N];

			// rooms 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					rooms[i][j] = sc.nextInt();
				}
			}

			// bfs 돌리기. 방에 하나씩 돌면서!
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}
			
			System.out.println("#" + t + " " + roomNum + " " + maxRoom);
			
		}
	}

	/**
	 * 
	 * @param x : 시작 인덱스 x
	 * @param y : 시작 인덱스 y
	 */
	private static void bfs(int x, int y) {
		queue.add(new Room(x, y, 1));

		// 상하좌우
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			Room room = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = room.x + dx[i];
				int ny = room.y + dy[i];
				
	
				if(nx >=0 && nx < N && ny >= 0 && ny < N &&  rooms[nx][ny]-rooms[room.x][room.y] == 1) {
					queue.add(new Room(nx,ny, room.distance+1));
				}else {
					if(maxRoom == room.distance){
						roomNum = Math.min(roomNum, rooms[x][y]);
					}
					else if(maxRoom < room.distance) {
						maxRoom = room.distance;
						roomNum = rooms[x][y];
					}
				}
			}

		}
		
//		System.out.println("시작점이 " + rooms[x][y] + "인 방에서 시작하면 ? " + roomCount + "개의 방을 들림");


	}
}

class Room {
	int x;
	int y;
	int distance; // 현재까지의 거리

	public Room(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}