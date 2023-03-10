package 일차원배열;

import java.util.Scanner;

public class OX퀴즈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i < arr.length; i++) {
			String str = sc.next();
			int score = 0;
			int a = 0;
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j)=='O') {
					if(j==0) {
						score+=1;
					}else {
						for(int k = a; k <= j; k++) {
							if(str.charAt(k)=='O') {
								score+=1;
							}
						}
					}
				}else {
					a = j;
				}
			}
			arr[i] = score;
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
