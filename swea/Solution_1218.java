import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1218 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			Stack<Character> stack = new Stack<>();

			int N = sc.nextInt(); // 테스트 케이스 길이

			String str = sc.next();
			for (int i = 0; i < str.length(); i++) {
				char bracket = str.charAt(i);

//				if(bracket == '{' || bracket == '[' || bracket =='(' || bracket == '<') {
//					stack.push(bracket);
//				}
				if (stack.empty())
					stack.push(bracket);

				else if (bracket == '}' && stack.peek() == '{') {

					stack.pop();

				} else if (bracket == ']' && stack.peek() == '[') {

					stack.pop();

				} else if (bracket == ')' && stack.peek() == '(') {

					stack.pop();

				} else if (bracket == '>' && stack.peek() == '<') {

					stack.pop();

				} else {
					stack.push(bracket);
				}
			}

			int answer = 0;
			if (stack.isEmpty()) {
				answer = 1;
			}
			System.out.printf("#%d %d\n", t, answer);
		}
	}
}