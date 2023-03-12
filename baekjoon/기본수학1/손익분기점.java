package 기본수학1;

import java.util.Scanner;

public class 손익분기점 {
	public static void main(String[] args) {

	 Scanner sc = new Scanner(System.in);
	 int result = -1;
	 
	 int A = sc.nextInt();
	 int B = sc.nextInt();
	 int C = sc.nextInt();
	 
	 if(C > B) {	// C < B�� ������ ���ͺб��� �Ȼ���.
		 int sub = C-B;
		 
		 int a = A / sub;
		 result = a+1;
	 }
	
	 System.out.println(result);
	 
	}
}
