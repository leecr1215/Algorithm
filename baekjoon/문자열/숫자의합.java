package ���ڿ�;

import java.util.Scanner;

public class �������� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String s = sc.next();
		int sum = 0;
		for(int i = 0; i < N; i++) {
			char c = s.charAt(i);
			sum += Character.getNumericValue(c);
		}
		System.out.println(sum);
	}
}

