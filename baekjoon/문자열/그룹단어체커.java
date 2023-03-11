package 문자열;

import java.util.Scanner;
import java.util.Stack;

public class 그룹단어체커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int Noword = 0;
		
		for(int i = 0; i < N; i++) {
			Stack<Character> st = new Stack<>();
			String s = sc.next();
			boolean check = true;
			for(int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if(st.contains(c)) {
					if(st.peek()!=c) {
						check = false;
					}
				}
				st.push(c);
			}
			if(check == false) {
				Noword++;
			}
		}
		
		System.out.println(N-Noword);
	}
}
