package ���Ʈ����;

import java.util.Scanner;

public class ������ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// N �ڸ���?
		int num = 0;
		long temp = N;
		while(temp!=0) {
			temp /= 10;
			num++;
		}
		
		// N - �ڸ���*9 ~ N����
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
