package 기타;

import java.util.Scanner;

public class 백준_2738 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] arr1 = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(sc.nextInt() + arr1[i][j] + " ");
			}
			System.out.println();
		}

	}
}
