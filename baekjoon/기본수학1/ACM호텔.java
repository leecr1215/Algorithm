package 기본수학1;

import java.util.Scanner;

public class ACM호텔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			int h = sc.nextInt();	// 호텔 층수
			int w = sc.nextInt();	// 각 층의 방수
			int n = sc.nextInt();	// 몇 번째 손님
			// 6 12 10
			// 10 나누기 6 -> 몫 1 나머지 4
			// 나머지 * 100 + (몫+1) 

			int remainder = (n % h)*100;
			int quotient = (n / h) + 1;
			if(remainder==0) {
				remainder = h*100;
				quotient -= 1;
			}
			
			System.out.println(remainder+quotient);
			//1
			//6 12 12
			// 12 나누기 6 -> 몫 2 나머지 0
			// 답: 602
		}
	}

}
