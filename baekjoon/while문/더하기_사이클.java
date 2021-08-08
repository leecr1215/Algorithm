package while문;

import java.util.Scanner;
public class 더하기_사이클 {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		int cycle = 0;
		int N = input.nextInt();	//26
		int help = N;
		while(true) {
			int first = help/10;	//26을 10으로 나눈 몫 == 2
			int second = help%10;	//26을 10으로 나눈 나머지 == 6	
			int sum = first + second;	//2+6==8
			int newNum = second*10 + sum%10;	//60+8 == 68
			help = newNum;
			cycle++;
			
			if(N==help) {
				System.out.println(cycle);
				break;
			}
		}
		
		
		
		
		
	
		
	}

}
