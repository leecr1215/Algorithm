import java.util.Scanner;

public class Solution_1247_최적경로 {
	
	static int N; // 고객 수
	static int min; // 최솟값
	static Node[] numbers; // 고객 저장
	static boolean[] visited;
	
	static Node company;
	static Node home;
	static Node[] customers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 고객의 수
			
			company = new Node(sc.nextInt(), sc.nextInt());
			home = new Node(sc.nextInt(), sc.nextInt());
			customers = new Node[N];
			
			for(int i = 0; i < N; i++) {
				customers[i] =  new Node(sc.nextInt(), sc.nextInt());
			}
			
			min = Integer.MAX_VALUE;
			numbers = new Node[N];
			visited = new boolean[N];
			
			permutation(0);
			
			System.out.println("#" + t + " " + min);
		}
		
	}
	
	// 고객 N명 중에 N명 뽑기
	// 그 후 거리 구해서 최소값 갱신
	private static void permutation(int cnt) {
		if(cnt == N) {
			int sum = 0;
			
			// 회사 -> 고객0
			sum += Math.abs(company.x-numbers[0].x) + Math.abs(company.y-numbers[0].y);
			
			// 고객 0 ~ 고객 N-1
			for(int i = 0; i < N-1; i++) {
				sum += Math.abs(numbers[i].x-numbers[i+1].x) + Math.abs(numbers[i].y-numbers[i+1].y);
			}
					
			// 고객 N-1 -> 집
			sum += Math.abs(numbers[N-1].x-home.x) + Math.abs(numbers[N-1].y-home.y);
			
			min = Math.min(sum, min);
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			numbers[cnt] = customers[i];
			visited[i] = true;
			
			permutation(cnt + 1);
			
			visited[i] = false;
		}
		
	}
}



class Node {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + "]";
	}
	
	
}
