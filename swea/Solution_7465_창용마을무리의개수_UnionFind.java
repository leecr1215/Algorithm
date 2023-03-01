import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_7465_창용마을무리의개수_UnionFind {
	
	static int N;
	static Integer[] parents;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 창용 마을에 사는 사람 수
			int M = sc.nextInt(); // 서로를 알고 있는 사람의 관계 수
			
			makeSet();
			
			for(int i = 0; i < M; i++) {
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				
				// num1과 num2 union find하기
				union(num1, num2);
				
			}
			
			
			// parents 배열을 set에 넣어서 set의 size 출력
			Set<Integer> set = new HashSet<>();
			for(int i = 1; i <= N; i++) {
				set.add(findSet(parents[i]));
			}
			
			System.out.println("#"+t+" "+ set.size());
		}
	}

	private static void makeSet() {
		parents = new Integer[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	private static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA == rootB) return;
		
		parents[rootB] = rootA;
	}
	
	private static int findSet(int a) {
		if(parents[a]==a) return a;
		
		return parents[a] = findSet(parents[a]);
	}
}
