package 브루트포스;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] papers = new int[101][101];

		
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j = x; j < x+10; j++) {
				for(int k = y; k < y+10; k++) {
					papers[j][k] = 1;
				}
			}
		}
		
		int count = 0;
		for(int j = 0; j < 101; j++) {
			for(int k = 0; k < 101; k++) {
				if(papers[j][k] == 1) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}
}
