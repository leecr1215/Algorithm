package 일차원배열;

import java.util.Scanner;

public class 최소and최대 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int[] array = new int[N];

		
		for(int i = 0; i < N; i++) {
			int a = input.nextInt();	
			array[i] = a;
		}
		int min = array[0];
		int max = array[0];
		
		for(int j = 0; j < N; j++) {
			if(max < array[j]) {
				max = array[j];
			}
			if(min > array[j]) {
				min = array[j];
			}
			
		}
		
		System.out.print(min + " " + max);
	}

}
