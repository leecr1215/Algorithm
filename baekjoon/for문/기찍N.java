package for��;

import java.util.Scanner;
public class ����N {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N;
		N = input.nextInt();
		
		for(int i = 0; i < N; i++){
			int minus = N - i;
			System.out.println(minus);
		}
	}

}
