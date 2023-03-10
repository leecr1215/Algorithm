package while문;

import java.util.Scanner;

public class A더하기B빼기4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (input.hasNextInt()) {

			int A = input.nextInt();
			int B = input.nextInt();
			
			System.out.println(A + B);
			
		}

	}
}
