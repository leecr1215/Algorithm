package if문;

import java.util.Scanner;
public class 알람시계 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int H, M;//H시 M분
		H = input.nextInt();
		M = input.nextInt();
		
		if(M<45) {
			H -= 1;
			M += 15;
			if(H < 0) {
				H = 23;
			}
		}else {
			M -= 45;
		}
		
		System.out.print(H +" "+ M);

	}

}
