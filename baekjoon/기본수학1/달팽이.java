package 기본수학1;

import java.util.Scanner;

public class 달팽이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 달팽이가 V-Bm 를  A-B씩 며칠?
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
		int day = (V-B-1) / (A-B)+1;
		
		
		System.out.println(day);
	}
}

/*
 * #include <stdio.h>

int main(void) {
	int A, B, V;
	scanf_s("%d %d %d", &A, &B, &V);
	int day = 0;
	day = (V - B) / (A - B);
	if ((V - B) % (A - B) != 0) {
		day++;
	}
	printf("%d", day);
	return 0;
}
*/
