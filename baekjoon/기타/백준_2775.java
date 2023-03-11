package 기타;

import java.util.Scanner;

public class 백준_2775 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();	
		
		for(int i = 0; i < t; i++) {
			int k = sc.nextInt();	// k층
			int n = sc.nextInt();	// n호
			
			int result = Person(n,k);
			//k층 T(n) = k-1층의 T(1) + ...+ T(n)
			System.out.println(result);
		}
	}
	
	private static int Person(int n, int k) {
		int p = 0;
		if(k==0) {
			p = n;
		}else {
			for(int i = 1; i <= n; i++) {
				p+=Person(i,k-1);
			}
		}
		return p;
	}

}
