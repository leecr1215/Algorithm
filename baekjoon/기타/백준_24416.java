package 기타;

import java.util.Scanner;

public class 백준_24416 {
    static int fibo1Num = 0;
	static int fibo2Num = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int fibo1Result = fibo1(n);
		int fibo2Result = fibo2(n);
		
		System.out.printf("%d %d", fibo1Result, fibo2Num);
		
		
	}
	
	public static int fibo1(int n) {
		fibo1Num++;
		if(n == 1 || n ==2) {
			return 1;
		}else {
			return fibo1(n-1) + fibo1(n-2);
		}
	}

	public static int fibo2(int n) {
		int[] fibonacci = new int[n+1];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		fibonacci[2] = 1;
		for(int i = 3; i <= n; i++) {
			fibo2Num++;
			fibonacci[i] = fibonacci[i-1]+fibonacci[i-2];
		}
		return fibonacci[n-1];
	}
}
