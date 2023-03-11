package 기타;

import java.util.Scanner;

public class 백준_2566 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int row = 0;
		int col = 0;
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				int temp = sc.nextInt();
				if(temp >= max) {
					max = temp;
					row = i+1;
					col = j+1;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(row + " " + col);
		
	}
}
