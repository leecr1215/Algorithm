import java.util.Scanner;
import java.util.Stack;

public class 백준__4949 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			Stack<Character> stack = new Stack<>();
			String temp = sc.nextLine();
			if (temp.length() == 1 && temp.charAt(0) == '.')
				break;

			if (isBracket(temp)) {
				// 한 줄에 괄호가 포함되어있을 때
				for (int i = 0; i < temp.length(); i++) {
					char c = temp.charAt(i);

					if (!stack.isEmpty()) {
						char lastItem = stack.peek();
						if (c == ')') {
							if (lastItem == '(') {
								stack.pop();
							} else {
								stack.push(c);
							}
						} else if (c == ']') {
							if (lastItem == '[') {
								stack.pop();
							} else {
								stack.push(c);
							}
						} else if (c == '[') {
							stack.push(c);
						} else if (c == '(') {
							stack.push(c);
						}

					} else {
						if (isBracket(c)) {
							stack.push(c);
						}
					}
				}
			}
			boolean check = true;
			if (!stack.isEmpty()) {
				check = false;
			}
			System.out.println(check ? "yes" : "no");
		}

	}

	public static boolean isBracket(String st) {
		return st.contains("[") || st.contains("(") || st.contains(")") || st.contains("]");
	}

	public static boolean isBracket(char st) {
		return st == '[' || st == '(' || st == ')' || st == ']';
	}
}
