package for문;

import java.util.Scanner;
public class 합 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n;
		int sum=0;
		
		n = input.nextInt();
		
		sum= ((n)*(n+1))/2;
		
		System.out.println(sum);
	}
	}


