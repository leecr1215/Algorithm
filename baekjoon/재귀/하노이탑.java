package 재귀;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 하노이탑 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		/*
		 * A B C
		 * 1. n-1개의 원반을 A에서 다 B로 옮기기
		 * 2. A에 있는 원반을 C로 옮기기
		 * 3. B에서 C로 n-1개의 원반 옮기기
		 * */
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		sb.append((int)(Math.pow(2, N)-1)).append("\n");
		
		hannoi(N,1,2,3);
		
		System.out.println(sb);
	}

	private static void hannoi(int n, int start, int middle, int end) {
		
		if(n==1) {	// 원반 1개면 걍 move
			sb.append(start + " " + end + "\n");
		}
		else {
			hannoi(n-1, start, end, middle);	// start에서 end를 거쳐 middle로
			sb.append(start + " " + end + "\n");	// start에서 end로 이동
			hannoi(n-1, middle, start, end);	// middle에서 start를 거쳐 end로 
		}
	}

}
