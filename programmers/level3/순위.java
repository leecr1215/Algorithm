package level3;

import java.util.Arrays;

public class 순위 {
    public static void main(String[] args) {
		System.out.println(solution(5, new int[][] {{4,3},{4,2},{3,2},{1,2},{2,5}}));
	}
	
	static final int INF = 9999999;
	
	public static int solution(int n, int[][] results) {
		
		int[][]dist = new int[n+1][n+1];
		
		// dist를 모두 0으로  채우기
		for(int i = 1; i < n+1; i++) {
			Arrays.fill(dist[i], 0);
		}
		
		// results로 갈 수 있는 방향은 1로 변경(이긴경우)
		// 진 경우에 -1 넣기
		for(int[] node : results) {
			dist[node[0]][node[1]] = 1;
			dist[node[1]][node[0]] = -1;
		}
		
		// 플로이드 워셜
		for(int k = 1; k < n+1; k++) {
			for(int i = 1; i < n+1; i++) {
				if(i==k) continue;
				
				for(int j = 1; j < n+1; j++) {
					if(i==j || j==k) continue;
					
					if(dist[i][k]==1 && dist[k][j]==1) {
						// 도달 가능한 경우(이긴 경우)
						dist[i][j] = 1;
						// 진경우
						dist[j][i] = -1;
					}
					
				}
			}
		}
		
		// dist 출력
//		for(int i = 1; i < n+1; i++) {
//			for(int j = 1; j < n+1; j++) {
//				System.out.print(dist[i][j]+ " ");
//			}
//			System.out.println();
//		}
//		
		// 순위 확정 조건 : n-1개의 승패를 알아야함
		int cnt = 0; // 순위 판단 가능한 선수 수
		
		for(int i = 1; i <= n; i++) {
			int nonZero = 0;
			for(int j = 1; j <= n; j++) {
				if(dist[i][j]!=0) nonZero++;
			}
			if(nonZero == n-1) cnt++;
		}
		
        return cnt;
    }
}
