package if¹®;

import java.util.Scanner;
public class À±³â {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year;//¿¬µµ
		
		year = input.nextInt();
		
		if ((year%4==0)&&((year%100!=0)||(year%400==0))){
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}

}
