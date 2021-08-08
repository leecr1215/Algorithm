package 문자열;

import java.util.Scanner;

public class 문자열반복 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			int repeat = sc.nextInt();
			String st = sc.next();
			
			for(int j = 0; j < st.length(); j++) {
				char c = st.charAt(j);
				for(int k = 0; k < repeat; k++) {
					System.out.print(c);
				}
			}
			System.out.println();
		}
	}
}
