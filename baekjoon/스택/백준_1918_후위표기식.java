package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 참고 블로그
// https://banjjak1.tistory.com/42?category=978267
// https://nahwasa.com/entry/%EB%B0%B1%EC%A4%80-1918-%EC%9E%90%EB%B0%94-%ED%9B%84%EC%9C%84-%ED%91%9C%EA%B8%B0%EC%8B%9D-boj-1918-java

// 연산자의 우선 순위가 높을 수록 스택의 상위에 위치!
// -> 우선 순위가 높은게 먼저 빠져야하니까

// ()는 우선 순위가 제일 낮다고 가정
// )를 만나면 현재 스택에 있는 모든 값을 pop
// 단, ()는 실제 값에 더해주면 안됨

public class 백준_1918_후위표기식 {

	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		changePreToPost(str);

		System.out.println(sb.toString());
	}

	/**
	 * 중위 표기식을 후위 표기식으로 변경
	 */
	private static void changePreToPost(String str) {
		Stack<Character> opStack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			// 알파벳인 경우 sb에 붙이기
			if (c >= 'A') {
				sb.append(c);
				continue;
			}
			// 연산자 or 소괄호인 경우

			// c가 여는 괄호일 때
			// 무조건 스택에 추가
			if (c == '(') {
				opStack.push(c);
				continue;
			}

			// 스택이 비어있는 경우
			if (opStack.isEmpty()) {
				opStack.push(c);
				continue;
			}

			// c가 닫는 괄호일 때
			// 현재 stack에 있는 모든 연산자들을 sb에 더해줌
			// 단, (이 나오면 더하는 것 중지
			if (c == ')') {
				while (opStack.peek() != '(') {
					sb.append(opStack.pop());
				}
				opStack.pop(); // ( 는 스택에서 빼주기
				continue;
			}

			// c가 스택의 top보다 우선순위가 같거나 낮으면
			// sb에 c보다 우선순위 높은 스택에 있는 애들을 모두 sb에 붙임
			while (!opStack.isEmpty() && getPriority(opStack.peek()) >= getPriority(c)) {
				sb.append(opStack.pop());
			}

			// 이제 스택의 top 이 c보다 우선순위가 높음
			opStack.push(c);

		}

		// 스택에 남은 값 더해주기
		while (!opStack.isEmpty()) {
			sb.append(opStack.pop());
		}

	}

	/**
	 * 연산자 우선 순위 반환
	 */
	public static int getPriority(char operator) {
		switch (operator) {
		case '*':
		case '/':
			return 3;

		case '+':
		case '-':
			return 2;

		case '(':
			return 1;
		default: 
			return -1;
		}
		
	}
}
