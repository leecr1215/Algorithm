package if��;

import java.util.Scanner;

public class �μ��� {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int A, B;

		A = input.nextInt();
		B = input.nextInt();

		if (A > B) {
			System.out.println(">");
		} else if (A < B) {
			System.out.println("<");
		} else {
			System.out.println("==");
		}

	}

}
