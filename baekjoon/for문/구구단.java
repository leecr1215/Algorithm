package for문;

import java.util.Scanner;

public class 구구단 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N;

		N = input.nextInt();
		for (int i = 1; i < 10; i++) {
			System.out.println(N + " * " + i + " = " + N * i);

		}
	}

}
