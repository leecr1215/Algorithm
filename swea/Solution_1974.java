import java.util.Scanner;

public class Solution_1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t < T; t++) {
			int[][] sudoku = new int[9][9];
			boolean result = true;

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}

			// 행 검증
			for (int i = 0; i < 9; i++) {
				int[] check = new int[9];
				for (int j = 0; j < 9; j++) {
					check[sudoku[i][j] - 1] += 1;
				}
				for (int j = 0; j < 9; j++) {
					if (check[j] == 0) {
						result = false;
						break;
					}
				}
			}

			// 세로 검증
			if (result == true) {
				for (int i = 0; i < 9; i++) {
					int[] check = new int[9];
					for (int j = 0; j < 9; j++) {
						check[sudoku[j][i] - 1] += 1;
					}
					for (int j = 0; j < 9; j++) {
						if (check[j] == 0) {
							result = false;
							break;
						}
					}
				}
			}

			// 3x3 검증
			if(result == true) {
				for(int i = 0; i < 9; i+=3) {
					for (int j = 0; j < 9; j+=3) {
						int[] check = new int[9];
						for(int k = i; k < i+3; k++) {
							for(int l = j; l < j+3; l++) {
								check[sudoku[k][l] - 1] += 1;
							}
						}
						for (int k = 0; k < 9; k++) {
							if (check[k] == 0) {
								result = false;
								break;
							}
						}
						if(result == false) {
							break;
						}
					}
				}
			}
			
			if(result == true) {
				System.out.printf("#%d %d\n", t, 1);
			}else {
				System.out.printf("#%d %d\n", t, 0);
			}

		}
	}
}

