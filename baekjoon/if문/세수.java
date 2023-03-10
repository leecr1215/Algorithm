package if문;

import java.util.Scanner;

public class 세수 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int A, B, C;
		A = input.nextInt();
		B = input.nextInt();
		C = input.nextInt();

		if (A > B) {
			if (B > C) {
				System.out.println(B);
			} else {
				if (A > C) {
					System.out.println(C);
				} else {
					System.out.println(A);
				}
			}
		} else {// A<=B
			if (A > C) {
				System.out.println(A);
			} else {// A<=C
				if (B < C) {
					System.out.println(B);
				} else {
					System.out.println(C);
				}
			}
		}
	}

}
