package 일차원배열;

import java.util.Scanner;

public class 평균 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		double[] arr = new double[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextDouble();
		}
		
		double max = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr[i]/max*100;
		}
		
		double average  = 0;
		
		for(int i = 0; i < arr.length; i++) {
			average += arr[i];
		}
		
		average = average / N;
		System.out.println(average);
	}
}
