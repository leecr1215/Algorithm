package 재귀;

import java.util.Scanner;

public class 피보나치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int result = Fibonacci(n);
		
		System.out.println(result);
	}


	private static int Fibonacci(int n) {
		if(n == 0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 1;
		}
		int a = Fibonacci(n-1) + Fibonacci(n-2);

		return a;
	}
}
