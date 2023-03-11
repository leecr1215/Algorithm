package 기타;

import java.util.Scanner;

public class 백준_2292 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int sub = (N-1)/6;
		if((N-1)%6!=0) {
			sub++;
		}
		
		
		int num = 1;
		int result=0;
		while(sub>0) {
			sub -= num;
			num++;
			result++;
		}
		
		System.out.println(result+1);
		
	}
}
