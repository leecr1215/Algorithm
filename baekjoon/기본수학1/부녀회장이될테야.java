package ±âº»¼öÇĞ1;

import java.util.Scanner;

public class ºÎ³àÈ¸ÀåÀÌµÉÅ×¾ß {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();	
		
		for(int i = 0; i < t; i++) {
			int k = sc.nextInt();	// kÃş
			int n = sc.nextInt();	// nÈ£
			
			int result = Person(n,k);
			//kÃş T(n) = k-1ÃşÀÇ T(1) + ...+ T(n)
			System.out.println(result);
		}
	}
	
	private static int Person(int n, int k) {
		// TODO Auto-generated method stub
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
