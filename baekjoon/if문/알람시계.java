package if��;

import java.util.Scanner;
public class �˶��ð� {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int H, M;//H�� M��
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
