package 기본수학1;

import java.util.Scanner;

public class 설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] array = new int[N+1];
		
		int result = 0;
		
		while(true) {
			if(N % 5 == 0) {
				result += N / 5;
				break;
			}
			
			N = N - 3;
			result++;
			
			if(N < 0) {
				result = -1;
				break;
			}
		}
		
		System.out.println(result);
	}
}
