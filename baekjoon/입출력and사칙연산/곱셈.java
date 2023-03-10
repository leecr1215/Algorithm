package 입출력and사칙연산;

import java.util.Scanner;
public class 곱셈 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String b;
		int a, c, d, e, f;

		a = input.nextInt();
		b = input.next();
		c = ((int) (b.charAt(2)) - 48) * a;
		d = ((int) (b.charAt(1)) - 48) * a;
		e = ((int) (b.charAt(0)) - 48) * a;
		f =  c + 10 * d + 100 * e;

		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);

	}

}
