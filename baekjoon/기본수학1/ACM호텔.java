package 기본수학1;
import java.util.Scanner;

public class ACM호텔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			int h = sc.nextInt();	// ȣ�� ����
			int w = sc.nextInt();	// �� ���� ���
			int n = sc.nextInt();	// �� ��° �մ�
			// 6 12 10
			// 10 ������ 6 -> �� 1 ������ 4
			// ������ * 100 + (��+1) 

			int remainder = (n % h)*100;
			int quotient = (n / h) + 1;
			if(remainder==0) {
				remainder = h*100;
				quotient -= 1;
			}
			
			System.out.println(remainder+quotient);
			//1
			//6 12 12
			// 12 ������ 6 -> �� 2 ������ 0
			// ��: 602
		}
	}

}
