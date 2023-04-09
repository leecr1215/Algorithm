package 기타;

import java.util.Scanner;

public class 백준_15829_Hashing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		
		String str= sc.next();
		
		long sum = 0;
		long pow = 1;
		for(int i = 0; i < L; i++) {
			int ascii = (int)str.charAt(i);
//			System.out.println(ascii);
			
			sum += (ascii-96) * pow;
			pow = (pow*31)%1234567891;
		}
		
		System.out.println(sum % 1234567891);
	}
}