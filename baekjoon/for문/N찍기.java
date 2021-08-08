package for¹®;

import java.util.Scanner;
public class NÂï±â {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n;
		n = input.nextInt();
		
		for (int i = n; i > 0 ; i--) {
			int minus = n - i + 1;  
			System.out.println(minus);
		}
	}

}
