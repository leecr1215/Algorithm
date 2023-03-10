package 재귀;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 하노이탑 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		/*
		 * A B C
		 * 1. n-1���� ������ A���� �� B�� �ű��
		 * 2. A�� �ִ� ������ C�� �ű��
		 * 3. B���� C�� n-1���� ���� �ű��
		 * */
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		sb.append((int)(Math.pow(2, N)-1)).append("\n");
		
		hannoi(N,1,2,3);
		
		System.out.println(sb);
	}

	private static void hannoi(int n, int start, int middle, int end) {
		
		if(n==1) {	// ���� 1���� �� move
			sb.append(start + " " + end + "\n");
		}
		else {
			hannoi(n-1, start, end, middle);	// start���� end�� ���� middle��
			sb.append(start + " " + end + "\n");	// start���� end�� �̵�
			hannoi(n-1, middle, start, end);	// middle���� start�� ���� end�� 
		}
	}

}
