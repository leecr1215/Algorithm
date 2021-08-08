package 일차원배열;

import java.util.Scanner;

public class 평균은_넘겠지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			int stuNum = sc.nextInt();
			double[] arr = new double[stuNum];
			
			
			double average = 0;
			for(int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
				average+= arr[j];
			}
			
			average = average / stuNum; 
			
			double over = 0;
			
			for(int j = 0; j < arr.length; j++) {
				if(average < arr[j]) {
					over += 1;
				}
			}
			
			double result = over*100/stuNum;
			
			result = Math.round(result*1000) / 1000.0;
			
			
			System.out.println(String.format("%.3f", result)+"%");
			
		}
	}
}
