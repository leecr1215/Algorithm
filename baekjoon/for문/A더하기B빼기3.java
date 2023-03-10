package for문;

import java.util.Scanner;
public class A더하기B빼기3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		for(int i = 0; i < T; i++ ) {
			int A,B;
			A = input.nextInt();
			B = input.nextInt();
			
			System.out.println(A+B);
		}
	}
}
