package 문자열;

import java.util.Scanner;

public class 아스키코드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char c = str.charAt(0);
		int i = c;
		System.out.println(i);
	}
}
