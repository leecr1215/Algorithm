package 입출력and사칙연산;

import java.util.Scanner;
public class 나머지 {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int A,B,C;
		
		A = input.nextInt();
		B = input.nextInt();
		C = input.nextInt();
		
		System.out.println((A+B)%C);
		System.out.println((A%C + B%C)%C);
		System.out.println((A*B)%C);
		System.out.println((A%C * B%C)%C);
	}

}
