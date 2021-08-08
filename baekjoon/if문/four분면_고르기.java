package if문;

import java.util.Scanner;

public class four분면_고르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int quadrant=0;
		
		if(x >= 0 && y >= 0) {	// 1사분면
			quadrant = 1;
		}else if(x >= 0 && y < 0) { // 4사분면
			quadrant = 4;
		}else if(x < 0 && y >= 0) {	//2사분면
			quadrant = 2;
		}else {	// 3사분면
			quadrant = 3;
		}
		
		System.out.println(quadrant);
	}
}
