package for문;

import java.util.Scanner;

public class 별찍기빼기2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int k = 0; k < N-i-1; k++) {
				System.out.print(" ");
			}
			for(int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}

}
