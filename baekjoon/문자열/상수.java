package 문자열;

import java.util.Scanner;

public class 상수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		
		String reA = "";
		String reB = "";
		
		for(int i = 0; i < A.length(); i++) {
			reA += A.charAt(A.length()-i-1);
		}
		
		for(int i = 0; i < B.length(); i++) {
			reB += B.charAt(B.length()-i-1);
		}
		
		if(Integer.parseInt(reA)>Integer.parseInt(reB)) {
			System.out.println(reA);
		}else {
			System.out.println(reB);
		}
		
	}
}
