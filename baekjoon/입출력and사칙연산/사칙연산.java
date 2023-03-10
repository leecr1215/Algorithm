package 입출력and사칙연산;
import java.util.Scanner;
public class 사칙연산 {
	public static void main(String[] args) {
		int A, B;
		int C;
		Scanner input = new Scanner(System.in);
		
		A = input.nextInt();
		B = input.nextInt();
		C = A / B;
		
		System.out.println(A + B);
		System.out.println(A - B);
		System.out.println(A * B);
		System.out.println(C);
		System.out.println(A % B);
		
	}

}
