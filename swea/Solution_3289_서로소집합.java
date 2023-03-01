import java.util.Scanner;

public class Solution_3289_서로소집합 {
	
	static int n;
	static int[] parents;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();

			n = sc.nextInt();
			int m = sc.nextInt();
			
			parents = new int[n+1];
			
			for(int i = 1; i <= n; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < m; i++) {
				int check = sc.nextInt(); // 0이면 union, 1이면 집합확인
				int a = sc.nextInt();
				int b = sc.nextInt();

				if (check == 0) { // union 연산
					union(a,b);
				} else if (check == 1) {
					// boolean 값 출력
					sb.append(findSet(a) == findSet(b) ? 1 : 0);
				}
			}
			
			System.out.println("#"+t+" "+sb.toString());
		}
	}
	
	/**
	 * a와 b의 union
	 * b를 a에 집합에 넣기
	 * @param a
	 * @param b
	 */
	private static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA == rootB) return;
		
		parents[rootB] = rootA; // B의 부모를 A로 변경
	}
	
	/**
	 * a의 대표 원소 찾기
	 * @param a
	 * @return
	 */
	private static int findSet(int a) {
		// a의 부모가 a면 return
		if(parents[a]==a) return a;
		
		// a의 부모를 대표로 변경
		return parents[a] = findSet(parents[a]);
	}
}
