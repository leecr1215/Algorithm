package while��;

import java.util.Scanner;
public class ���ϱ�_����Ŭ {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		int cycle = 0;
		int N = input.nextInt();	//26
		int help = N;
		while(true) {
			int first = help/10;	//26�� 10���� ���� �� == 2
			int second = help%10;	//26�� 10���� ���� ������ == 6	
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
