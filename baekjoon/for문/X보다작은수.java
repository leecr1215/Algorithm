package for��;

import java.util.Scanner;

public class X���������� {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int X = input.nextInt();

		for (int i = 0; i < N; i++) {
			int A = input.nextInt();
			if (A < X) {
				System.out.print(A + " ");
			}
		}

	}

}
