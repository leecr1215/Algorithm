package 입출력and사칙연산;

import java.util.Scanner;

public class 나누기 {
	public static void main(String[] args) {
		int A, B;
		double C;
		
		Scanner input = new Scanner(System.in);
		
		A = input.nextInt();
		B = input.nextInt();
		
		C = A / (double)B;
		
		System.out.print(C);
	}

}


