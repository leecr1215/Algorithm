package 기본수학1;


import java.util.Scanner;

public class 부녀회장이될테야 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();	
		
		for(int i = 0; i < t; i++) {
			int k = sc.nextInt();	// k��
			int n = sc.nextInt();	// nȣ
			
			int result = Person(n,k);
			//k�� T(n) = k-1���� T(1) + ...+ T(n)
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
