import java.util.Scanner;

public class Solution_1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t<=T; t++) {
			int N = sc.nextInt();
			
			int[][] matrix = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			
			int[][] rotate_90 = rotation(matrix);
			int[][] rotate_180 = rotation(rotate_90);
			int[][] rotate_270 = rotation(rotate_180);
			
			System.out.printf("#%d\n", t);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(rotate_90[i][j]);
				}
				System.out.print(" ");
				
				for(int j = 0; j < N; j++) {
					System.out.print(rotate_180[i][j]);
				}
				System.out.print(" ");
				
				for(int j = 0; j < N; j++) {
					System.out.print(rotate_270[i][j]);
				}
				System.out.println();
			}
			
		}
	}
	
	public static int[][] rotation(int[][] arr){
		int len = arr.length;
		int[][] result = new int[len][len];
		
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				result[i][j] = arr[len-j-1][i];
			}
		}
		
		return result;
	}
}
