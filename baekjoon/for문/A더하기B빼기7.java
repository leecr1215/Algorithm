package for문;

import java.util.Scanner;
public class A더하기B빼기7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		
		for (int i = 1; i < T+1; i++) {
			int A = input.nextInt();
			int B = input.nextInt();
			int add = A + B;
			
			System.out.println("Case #"+i+": "+""+ add);
			
		}
	}

}
