package �������迭;

import java.util.Scanner;

public class �����ǰ��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int mult = a*b*c;
		
		int[] array = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
		
		while(mult > 0) {
			array[mult%10] += 1;
			mult = mult / 10;
		}
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
	}
}
