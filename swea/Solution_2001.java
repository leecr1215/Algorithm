import java.util.Scanner;

public class Solution_2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] array = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					array[i][j] = sc.nextInt();
				}
			}
			
			
			int maxFlyNum = 0;
			
			for(int i = 0; i < N-M+1; i++) {
				for(int j = 0; j < N-M+1; j++) {
					int flyNum = 0;
					for(int k = i; k < i + M; k++) {
						for(int o = j; o < j + M; o++) {
							flyNum += array[k][o];
						}
					}
					if(flyNum > maxFlyNum) {
						maxFlyNum = flyNum;
					}
				}
			}
			System.out.printf("#%d %d\n", t, maxFlyNum);
		}
	}
}