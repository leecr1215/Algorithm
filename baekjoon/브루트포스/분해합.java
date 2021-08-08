package 브루트포스;

import java.util.Scanner;

public class 분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// N 자릿수?
		int num = 0;
		long temp = N;
		while(temp!=0) {
			temp /= 10;
			num++;
		}
		
		// N - 자릿수*9 ~ N까지
		long start = N - num*9;
		long result = 0;
		
		boolean find = false;
		
		
		for(long i = start; i <= N; i++) {
			long sum = 0;
			long number = i;
			
			while(number!=0) {
				sum += number % 10;
				number /= 10;
			}
			
			if(sum+i == N) {
				find = true;
				result = i;
				break;
			}
		}
		
		if(find==false) {
			System.out.println("0");
		}else {
			System.out.println(result);
		}
	}
}
