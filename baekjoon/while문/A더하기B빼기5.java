package while문;

import java.util.Scanner;

public class A더하기B빼기5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (true) {

			int A = input.nextInt();
			int B = input.nextInt();
			if (A == 0 && B == 0) {
				break;
			}
			System.out.println(A + B);

		}
	}
}
